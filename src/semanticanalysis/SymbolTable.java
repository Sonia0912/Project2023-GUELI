package semanticanalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import ast.BoolType ;
import ast.IntType;
import ast.Type;

public class SymbolTable {

	private ArrayList<HashMap<String,STentry>>  symbol_table ;
	private ArrayList<Integer> offset ;
	
	public SymbolTable() {
		symbol_table = new ArrayList<HashMap<String,STentry>>() ;
		offset = new ArrayList<Integer>() ;
	}
	
	public Integer nesting() {
		return symbol_table.size() -1 ;
	}
	
	public STentry lookup(String id) {
		int n = symbol_table.size() - 1 ;
		boolean found = false ;
		STentry T = null ;
		while ((n >= 0) && !found) {
			HashMap<String,STentry> H = symbol_table.get(n) ;
			T = H.get(id) ;
			if (T != null) found = true ;
			else n = n-1 ;
		}
		return T ;
	}

	public Integer nslookup(String id) {
		int n = symbol_table.size() - 1 ;
		boolean found = false ;
		while ((n >= 0) && !found) {
			HashMap<String,STentry> H = symbol_table.get(n) ;
			if (H.get(id) != null) found = true ;
			else n = n-1 ;
		}
		return n ;
	}

	public void add(HashMap<String,STentry> H) {
		symbol_table.add(H) ;
		offset.add(1) ;		// si inizia da 2 perche` prima ci sonop FP e AL
	}
	
	public void remove() {
		int x = symbol_table.size() ;
		symbol_table.remove(x-1) ;
		offset.remove(x-1) ;
	}
	
	public boolean top_lookup(String id) {
		int n = symbol_table.size() - 1 ;
		STentry T = null ;
		HashMap<String,STentry> H = symbol_table.get(n) ;
		T = H.get(id) ;
		return (T != null) ;
	}
	
	public void insert(String id, Type type, int _nesting, String _label) {
		int n = symbol_table.size() - 1 ;
		HashMap<String,STentry> H = symbol_table.get(n) ;
		symbol_table.remove(n) ;
		int offs = offset.get(n) ;
		offset.remove(n) ;
		STentry idtype = new STentry(type,offs,_nesting, _label) ;
		H.put(id,idtype) ;
		symbol_table.add(H) ;
		if (type.getClass().equals((new BoolType()).getClass()))
			offs = offs + 1 ; // we always increment the offset by 1 otherwise we need ad-hoc
							  // bytecode operations
		else if (type.getClass().equals((new IntType()).getClass()))
			offs = offs + 1 ;
		else offs = offs + 1 ;
		offset.add(offs) ;	
	}

	public void increaseoffset() {
		int n = offset.size() - 1 ;
		int offs = offset.get(n) ;
		offset.remove(n) ;
		offs = offs + 1 ;
		offset.add(offs) ;	
	}

	public void printST() {
		System.out.println("******");
		for(int i = 0; i < symbol_table.size(); i++) {
			symbol_table.get(i).forEach((key, value) -> System.out.println(key + ": " + value.gettype().getClass() + ", " + value.getnesting()));
		}
		System.out.println("******");
	}

	// Aggiorna una entry dell'hashmap
/*	public void update(String id, STentry varToUpdate){
		int n = symbol_table.size() - 1 ;
		boolean found = false ;
		while ((n >= 0) && !found) {
			HashMap<String,STentry> H = symbol_table.get(n) ;
			if (H.get(id) != null) {
				found = true ;
				H.put(id,varToUpdate) ;
			} else n = n-1 ;
		}
	}*/

	// GETTER
	public ArrayList<HashMap<String,STentry>> getSymbol_table() {
		return this.symbol_table;
	}
	public ArrayList<Integer> getOffset() {
		return this.offset;
	}

	// SETTER
	/*
		Se in input riceve un'ArrayList appartenente a un'altra ST non
		referenziamo la ST precedente, ma ne creiamo una copia a se stante
	 */
	public void setSymbol_table(ArrayList<HashMap<String,STentry>> newST) {
		String currString = "";
		STentry currSTentry = new STentry(null, -1, -1);
		HashMap<String, STentry> currHM = new HashMap<String, STentry>();
		ArrayList<HashMap<String,STentry>> currAL = new ArrayList<HashMap<String,STentry>>();

		for(int i = 0; i < newST.size(); i++) {
			HashMap<String, STentry> newHM = new HashMap<String, STentry>(newST.get(i));
			for (HashMap.Entry<String, STentry> e : newHM.entrySet()) {
				currString = e.getKey();
				currSTentry = new STentry(e.getValue().gettype(), e.getValue().getoffset(), e.getValue().getnesting());
				currSTentry.setInitialized(e.getValue().getInitialized());
				currHM.put(currString, currSTentry);
			}
			currAL.add(currHM);
		}

		this.symbol_table = currAL;
	}
	public void setOffset(ArrayList<Integer> newOffset) {
		this.offset = new ArrayList<Integer>(newOffset);
	}

	// Setta la symbol_table e l'offset ai valori ricevuti in input
	public void restore(ArrayList<HashMap<String,STentry>> oldST, ArrayList<Integer> oldOff){
		this.setSymbol_table(oldST);
		this.setOffset(oldOff);
	}
}
