public class Sortieren {
    public static void sort(int[] array){
        //Ab hier soll die Methode sort implementiert werden.
        for (int i = array.length;i>1;i--){
            for (int j = 0;j<i-1;j++){
                if( array[j]> array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        // TODO: Ab hier soll die main-Methode implementiert werden.
        int[] a = {9,8,6,9,4,5};
        sort(a);
        for(int i = 0;i<a.length;i++){
            System.out.println("Arr["+(i+1)+"] = "+a[i]);
        }
    }
}
