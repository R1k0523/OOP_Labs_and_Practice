package rtu.klokov.labs.lab10;

public class AnyTypeArray<E> {
        private E [] arr;

        public E getArrIndex(int i){
            return  arr[i] ;
        }

        public void setArr( E [] arr){
            this.arr =  arr;
        }

        public int getLength(){
            return  arr.length ;
        }


}
