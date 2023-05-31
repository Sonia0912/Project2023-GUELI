grammar SimpLan;

@lexer::members {
   //there is a much better way to do this, check the ANTLR guide
   public int lexicalErrors=0;
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
       | 'if' '(' exp ')' '{' (stm)* '}' ('else' '{' (stm)* '}')?          #ifStm
	   ;

exp    :  INTEGER                                                          #intVal
          | ('true' | 'false')                                             #boolVal
       | ID                                                                #varExp
       | '!' exp                                                           #negExp
       | exp ('*' | '/') exp                                               #molDivExp
       | exp ('+' | '=') exp                                               #plusEqExp
       | exp ('>' | '<' | '>=' | '<=' | '==') exp                          #condExp
       | exp ('&&' | '||') exp                                             #andOrExp
       | 'if' '(' exp ')' '{' exp '}' 'else' '{' exp '}'                   #ifExp
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