import java.util.Arrays;


public class MedianOfTwo {
	/*
	 public double findMedianSortedArrays(int A[], int B[]) {
		 int la = A.length;
		 int lb = B.length;
		 int mid = (la + lb + 1) / 2;
		 if (la == 0) {
			 if (lb == 0) {
				 return 0;
			 }
			 else {
				 return B[lb / 2];
			 }
		 }
		 if (lb == 0) {
			 return A[la / 2];
		 }
	 }
	 
	 public boolean recur(int A[], int B[], int ia, int mid) {
		 if (ia < 0 || ia >= A.length) {
			 return false;
		 }
		 int ib = mid - 1 - ia;
		 if (ib)
	 }
	 */
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int la = A.length;
        int lb = B.length;
        if (la == 0 && lb == 0) {
        	return 0;
        }
        if (la == 0) {
        	if ((lb & 1) == 1) {
        		return B[lb / 2];
        	}
        	else {
        		return ((double)(B[lb/2] + B[lb/2 - 1])) / 2;
        	}
        }
        if (lb == 0) {
        	if ((la & 1) == 1) {
        		return A[la / 2];
        	}
        	else {
        		return ((double) (A[la / 2] + A[la / 2 - 1])) / 2;
        	}
        }
        if (la == 1) {
        	return merge(B, A[0]);
        }
        if (lb == 1) {
        	return merge(A, B[0]);
        }
        return recur(A, B, 0, la - 1);
    }
	
	public double recur(int[] A, int[] B, int start, int end) {
		//System.out.println("recur:");
		System.out.println("\tA: " + Arrays.toString(A) + "; B: " +Arrays.toString(B) + "; start = " + start + "; end = " + end);
		int med;
		int la = A.length;
		int lb = B.length;
		if (start > end) {
			return recur(B, A, 0, lb - 1);
		}
		int mid = (start + end) / 2;
		int j = (la + lb) / 2 - mid - 1;
		System.out.println("\tmid = " + mid + "; j = " + j);
		if ((j < 0 || (j < lb && A[mid] >= B[j])) && (j + 1 > lb - 1 || (j >= -1 && A[mid] <= B[j + 1]))) {
			med = mid;
		}
		else if (j >= lb || (j >= 0 && A[mid] < B[j])) {
			return recur(A, B, mid + 1, end);
		}
		else {
			return recur(A, B, start, mid - 1);
		}
		if (((la + lb) & 1) == 1) {
			//System.out.println("odd");
			return A[med];
		}
		else {
			//System.out.println("even");
			//System.out.println(A[med] + "; " + A[med - 1] + "; " + B[j]);
			if (med > 0 && j >= 0) {
				return ((double)(A[med] + Math.max(A[med - 1], B[j]))) / 2;
			}
			else if (med == 0 && j >= 0) {
				return ((double)(A[med] + B[j])) / 2 ;
			}
			else {
				return ((double)(A[med] + A[med - 1])) / 2;
			}
		}
	}
	
	public double merge(int[] a, int b) {
		int la = a.length;
		int[] arr = new int[la + 1];
		int i = la;
		for (; i > 0; i--) {
			if (a[i - 1] > b) {
				arr[i] = a[i - 1];
			}
			else {
				arr[i] = b;
				break;
			}
		}
		if (i == 0) {
			arr[0] = b;
		}
		else {
			for (i = i - 1; i >= 0; i--) {
				arr[i] = a[i];
			}
		}
		if ((arr.length & 1) == 1) {
			return arr[(la + 1) / 2];
		}
		else {
			return ((double)(arr[(la + 1) / 2] + arr[(la + 1) / 2 - 1])) / 2;
		}
	}
	
	public void test() {
		int[] A = new int[]{100000};
		int[] B = new int[]{100001};
		System.out.println(findMedianSortedArrays(A, B));
	}
}





/*
 * 
 * sophie's solution*/


/*
 double findMedian(int A[], int B[], int l, int r, int nA, int nB) {
if (l>r) return findMedian(B, A, max(0, (nA+nB)/2-nA), min(nB,
(nA+nB)/2), nB, nA);
int i = (l+r)/2;
int j = (nA+nB)/2 – i – 1;
if (j>=0 && A[i] < B[j]) return findMedian(A, B, i+1, r, nA, nB);
else if (j<nB-1 && A[i] > B[j+1]) return findMedian(A, B, l, i-1, nA, nB);
else {
if ( (nA+nB)%2 == 1 ) return A[i];
else if (i>0) return (A[i]+max(B[j], A[i-1]))/2.0;
else return (A[i]+B[j])/2.0;
}
}

double findMedianSortedArrays(int A[], int n, int B[], int m) {
if (n<m) return findMedian(A, B, 0, n-1, n, m);
else return findMedian(B, A, 0, m-1, m, n);
}
 */