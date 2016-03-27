// Team nodelanda: Manish Saha, Nalanda Sharadjaya
// APCS2 pd05
// HW14a -- On the DLL
// 2016-03-16

public class DLLNode<T> {
    private DLLNode<T> _prevNode;
    private T _cargo;
    private DLLNode<T> _nextNode;

    // constructor
    public DLLNode( DLLNode<T> prev, T value, DLLNode<T> next ) {
	_prevNode = prev;
	_cargo = value;
	_nextNode = next;
    }

    // accessors & modifiers
    public T getCargo() {
	return _cargo;
    }

    public T setCargo( T newCargo ) {
	T old = getCargo();
	_cargo = newCargo;
	return old;
    }

    public DLLNode<T> getNext() {
	return _nextNode;
    }

    public DLLNode<T> setNext( DLLNode<T> newNext ) {
	DLLNode<T> old = getNext();
	_nextNode = newNext;
	return old;
    }

    public DLLNode<T> getPrev() {
	return _prevNode;
    }

    public DLLNode<T> setPrev(DLLNode<T> newPrev) {
	DLLNode<T> old = getPrev();
	_prevNode = newPrev;
	return old;
    }

}
