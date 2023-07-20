import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {90,9,80,8,70,7};
        System.out.println("Before sort: "+Arrays.toString(a));
        mergeSort(a, a.length);
        System.out.println("After sort:  "+Arrays.toString(a));
    }

    static void mergeSort(int a[], int n){
        if(n<2) return;
        int mid = n/2;
        int l[] = new int[mid];
        int r[] = new int[n-mid];
        for(int i=0;i<mid;i++) l[i]=a[i];
        for(int i=mid;i<n;i++) r[i-mid]=a[i];
        mergeSort(l, mid);
        mergeSort(r, n-mid);
        merge(a,l,r,mid, n-mid);
    }

    static void merge(int a[], int l[], int r[], int left, int right){
        int i=0, j=0, k=0;
        while(i<left && j<right){
            if(l[i]<r[j]) a[k++]=l[i++];
            else a[k++]=r[j++];
        }      
        while(i<left) a[k++]=l[i++];
        while(j<right) a[k++]=r[j++];  
        System.out.println("sorted a: "+Arrays.toString(a)+" l: "+Arrays.toString(l)+" r: "+Arrays.toString(r));
    }
}
