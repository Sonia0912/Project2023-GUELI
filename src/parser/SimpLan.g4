grammar SimpLan;

@lexer::members {
   //there is a much better way to do this, check the ANTLR guide
   //public int lexicalErrors=0;
    @Override
       public void recover(RecognitionException ex)
       {
    throw new ParsingException(ex.getMessage(),getCharPositionInLine(),ex.getOffendingToken().getText());
           }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
  
prog   : exp                                                               #singExp
       | (dec)+  (stm)* (exp)?                                             #progDecStm
       ;

dec    : type ID ';'                                                       #idDec
       | type ID '(' ( param ( ',' param)* )? ')' '{' body '}'             #funDec
       ;

param  : type ID
;

body   : (dec)* (stm)* (exp)?                                              #bodyFun
	   ;

type   : 'int'
       | 'bool'
       | 'void'
       ;

stm   : ID '=' exp ';'                                                     #asg
       | ID '(' (exp (',' exp)* )? ')' ';'                                 #invFun
       | 'if' '(' cond=exp ')' '{' (thenBranch=stm)* '}'
       ('else' '{' (elseBranch=stm)* '}')?                                 #ifStm
	   ;

exp    :  INTEGER                                                          #intVal
          | ('true' | 'false')                                             #boolVal
       | ID                                                                #varExp
       | '!' exp                                                           #negExp
       | left=exp (molt='*') right=exp                                     #molExp
       | left=exp (div='/') right=exp                                      #divExp
       | left=exp (plus='+') right=exp                                     #plusExp
       | left=exp (equal='=') right=exp                                    #eqExp
       | left=exp (magg='>' | min='<' | maggeq='>='
       | mineq='<=' | eq='==') right=exp                                   #condExp
       | left=exp (and='&&') right=exp                                     #andExp
       | left=exp (or='||') right=exp                                      #orExp
       | 'if' '('cond=exp ')' '{' thenBranch=exp '}'
       'else' '{' elseBranch=exp '}'                                       #ifExp
       | '(' exp ')'                                                       #pareExp
       | ID '(' (exp (',' exp)* )? ')'                                     #funExp
       ;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

//Numbers
fragment DIGIT  : '0'..'9';
INTEGER         : DIGIT+;

//IDs
fragment CHAR   : 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

//ESCAPE SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS     : '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;

ERR             : .  -> channel(HIDDEN);