package jsjf;

import java.util.Iterator;

/**
 *
 * @author Hagen
 */
public class AlgebraicArraySet<T> extends ArraySet<T> {
  
  public AlgebraicArraySet<T> union(SetADT<T> set){
    AlgebraicArraySet<T> aas=new AlgebraicArraySet<>();
    Iterator<T> it=set.iterator();
    while(it.hasNext()){
      aas.add(it.next());
    }
    /*it=this.iterator();
    while(it.hasNext()){
      aas.add(it.next());
    }
*/
    for(T item:this){//for each. Para cada item de this, agregarlo.
      aas.add(item);
    }
    return aas;
  }
  
  public AlgebraicArraySet<T> intersection(SetADT<T> set){
    AlgebraicArraySet<T> aas=new AlgebraicArraySet<>();
    for(T item:this){
      if(set.contains(item)){
        aas.add(item);
      }
    }
    return aas;
  }
  
  public AlgebraicArraySet<T> difference(SetADT<T> set){
    AlgebraicArraySet<T> aas=new AlgebraicArraySet<>();
    for(T item:this){
      if(!set.contains(item)){
        aas.add(item);
      }
    }
    return aas;
  }
  
  
}