// Nalanda Sharadjaya
// APCS2 pd5
// HW18 -- For Each is the Goal
// 2016-03-27

import java.util.Iterator;

public class LList<T> implements List<T> {

    class MyIterator implements Iterator {

	private DLLNode tmp;

	public MyIterator() {
	    tmp = _head;
	}

	public boolean hasNext() {
	    if (tmp.getNext() != null) return true;
	    else return false;
	}

	public DLLNode next() {
	    return tmp.getNext();
	}

	public void remove() {
	    tmp = tmp.getNext();
	}
	
    }
    
    private DLLNode<T> _head;
    private int _size;

    //constructor
    public LList( ) {
	_head = null;
	_size = 0;
    }

    //add at end
    public boolean add( T newVal ) {
	add( size(), newVal );
	return true;
    }

    //add at index
    public void add( int index, T newVal ) {
	if ( index < 0 )
	    throw new IndexOutOfBoundsException();
	DLLNode<T> newNode; // node with newVal
	DLLNode<T> tmp = _head; // alias
	if ( index == 0 ) {
	    tmp = new DLLNode<T>( null, newVal, _head );
	    if ( _head != null ) _head.setPrev( tmp );
	    _head = tmp;
	}
	else {
	    newNode = new DLLNode<T>( null, newVal, null );
	    if ( index >= size() ) {
	        for ( int i = 0; i < size() - 1; i++ )
		    tmp = tmp.getNext();
		tmp.setNext( newNode );
		newNode.setPrev( tmp );
	    }
	    else {
		for ( int i = 0; i < index; i++ )
		    tmp = tmp.getNext();
		tmp.getPrev().setNext( newNode );
		newNode.setPrev( tmp.getPrev() );
		tmp.setPrev( newNode );
		newNode.setNext( tmp );
	    }
	}
	_size++;
    }

    //remove
    public T remove( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	T old;
	DLLNode<T> tmp = _head;
	if ( index == 0 ) {
	    old = tmp.getCargo();
	    tmp = tmp.getNext();
	    if ( tmp != null )
		tmp.setPrev( null );
	    _head = tmp;
	}
	else {
	    for ( int i = 0; i < index; i++ )
		tmp = tmp.getNext();   
	    old = tmp.getCargo();
	    DLLNode<T> prev = tmp.getPrev();
	    DLLNode<T> next = tmp.getNext();
	    if ( prev != null ) tmp.getPrev().setNext( next );
	    if ( next != null ) tmp.getNext().setPrev( prev );
	}
	_size--;
	return old;
    }

    //get
    public T get( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	T retVal;
	DLLNode<T> tmp = _head;
	for( int i = 0; i < index; i++ )
	    tmp = tmp.getNext();
	retVal = tmp.getCargo();
	return retVal;
    }

    //set
    public T set( int index, T newVal ) {
        if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	DLLNode<T> tmp = _head;
	for( int i = 0; i < index; i++ )
	    tmp = tmp.getNext();
	T oldVal = tmp.setCargo( newVal );
	return oldVal;
    }

    //size
    public int size() {
        return _size;
    }

    //iterator
    public Iterator<T> iterator() {
	return new MyIterator();
    }

    //toString()
    public String toString() { 
	String retStr = "NULL<-HEAD->";
	DLLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += "<-" + tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }

    public static void main( String[] args ) {

	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	System.out.println( "2nd item is: " + james.get(1) );
	System.out.println();

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println();

	System.out.println( james );
	System.out.println();
	
	james.add( 0, "foo" );
	System.out.println( james );
	System.out.println();

	james.add( 5, "poo" );
	System.out.println( james );
	System.out.println();
	
	System.out.println( james.remove( 5 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 2 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 1 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 1 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 1 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 0 ) );
	System.out.println( james );
	System.out.println();
	
    }

}
