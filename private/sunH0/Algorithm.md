## 정렬 알고리즘
정렬 알고리즘(3)
선택 정렬, 거품 정렬, 삽입 정렬
병합 정렬, 퀵 정렬, 힙 정렬

### 분류

#### 안전 정렬과 불안전 정렬
- 안전 정렬(Stable Sort) : 중복된 값을 입력 순서와 동일하게 정렬하는 알고리즘
- 불안전 정렬(Unstable Sort) : 중복된 값을 입력 순서와 동일하다는 보장 없이 정렬하는 알고리즘

#### 정렬 장소에 따른 분류
- 내부 정렬(internal sort) : 정렬할 자료를 메인 메모리에 올려서 정렬하는 방식이고 정렬 속도가 빠르지만 정렬할 수 있는 자료의 양이 메인 메모리의 용량에 따라서 제한된다.

- 외부 정렬(external sort) :  정렬할 자료를 보조 기억장치에서 정렬하는 방식이고 대용량의 보조 기억 장치를 사용하기 때문에 내부 정렬보다 속도는 떨어지지만 내부 정렬로 처리할 수 없는 대용량의 자료에 대한 정렬이 가능하다.

#### 실행 방법에 따른 분류



### Selection Sort
해당 인덱스에 들어올 원소를 탐색하여 위치를 교환하는 정렬 알고리즘

#### 시간 복잡도
- 최선, 평균, 최악의 시간 복잡도는 n^2이다. 

#### 공간 복잡도
- 주어진 공간 안에서 정렬이 이뤄지므로 공간복잡도는 n이다.

```java
public void selectSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int idx = i;
      int value = array[idx];
      for (int j = i; j < array.length; j++) {
        if (value > array[j]) {
          idx = j;
          value = array[j];
        }
      }
      int temp = array[i];
      array[i] = array[idx];
      array[idx] = temp;
    }
  }
```

#### 장점
- 알고리즘이 단순하다.
- 다른 메모리 공간을 필요로 하지 않는다.
- 정렬을 위한 비교 횟수는 많지만 교환 연산 횟수는 버블 정렬에 비해 적다.

#### 단점
- 시간복잡도가 O(n^2)으로, 비효율적이다.
- 불안정 정렬(Unstable Sort) 이다.

### bubbleSort
서로 인접한 두 원소의 대소를 비교하고, 조건에 맞지 않다면 자리를 교환하며 정렬하는 알고리즘. 

#### 시간 복잡도
- 정렬 여부에 상관없이 원소를 탐색하므로 최선, 평균, 최악의 시간 복잡도는 n^2이다. 
#### 공간 복잡도
- 주어진 공간 안에서 정렬이 이뤄지므로 공간복잡도는 n이다.

``` java
public void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }
```

#### 장점
- 다른 메모리 공간을 필요로 하지 않다. 
- 안전정렬이다.
- 구현이 간단하다.

#### 단점
- 시간복잡도가 모든 경우에 O(n^2)으로, 굉장히 비효율적이다.
- 교환 연산(swap)이 많이 일어난다.

### 삽입 정렬(Insertion Sort)
2번째 원소부터 시작하여 이전의 원소들과 비교하여 삽입할 위치를 지정한 후, 원소를 뒤로 옮기고 지정된 자리에 자료를 삽입 하여 정렬하는 알고리즘이다. selection sort는 인덱스를 기준으로 원소를 탐색했다면, insertion sort는 원소 값을 기준으로 어떤 index에 위치할지 탐색한다.

```java
public static void insertSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
			int target = array[i];
			int j = i - 1;
			
			while(j >= 0 && target < a[j]) {
				array[j + 1] = array[j];	
				j--;
			}
			
			array[j + 1] = target;	
    }
  }
```

#### 시간 복잡도
- 최악의 경우(역으로 정렬되어 있을 경우), 평균의 경우 시간 복잡도는 O(n^2) 이다.
- 모두 정렬이 되어있는 경우(Optimal)한 경우, 한번씩 밖에 비교를 안하므로 O(n) 이다.

#### 공간 복잡도
- 주어진 배열 안에서 교환(swap)을 통해, 정렬이 수행되므로 O(n) 이다.

#### 장점
- 다른 메모리 공간을 필요로 하지 않다. 
- 안전정렬이다.
- 대부분의 원소가 이미 정렬되어 있는 경우, 매우 효율적
- 삽입 정렬은 n번째 요소를 배치하는 데 필요한 만큼의 요소만 탐색하기 때문에 선택과 버블 정렬 보다 훨씬 효율적으로 실행된다.

#### 단점
- Bubble Sort와 Selection Sort와 마찬가지로, 배열의 길이가 길어질수록 비효율적이다.

### 병합 정렬(Merge Sort)
분할 정복 방식을 사용한 정렬 방법으로 배열을 더 이상 나눌 수 없을 때 까지 분할하고, merge하는 과정에서 정렬이 진행된다.  합병의 대상이 되는 두 영역이 각 영역에 대해서 정렬이 되어있기 때문에 단순히 두 배열을 순차적으로 비교하면서 정렬할 수가 있다.

+) 분할 정복 방식 (divide and conquer) : 문제를 작은 2개의 문제로 분리하고 각각을 해결한 다음, 결과를 모아서 원래의 문제를 해결하는 전략

#### 시간 복잡도
- 데이터의 분포에 영향을 받지않는 정렬 방식으로서 최선, 최악, 평균 시간 복잡도는 nlogn이다. (재귀 호출 logn * 병합 n)
#### 공간 복잡도

#### 장점
- 안전 정렬이다.
- 데이터의 분포에 영향을 받지않는다.
- 합병정렬은 순차적인 비교로 정렬을 진행하므로, LinkedList의 정렬이 필요할 때 사용하면 효율적이다.
  - 링크 인덱스만 변경되므로 데이터의 이동은 무시할 수 있을 정도로 작아진다.
  - 제자리 정렬(in-place sorting)로 구현할 수 있다.
  - 퀵정렬은, 순차 접근이 아닌 임의 접근이기 때문에 헤드부터 탐색하여 임의 원소에 접근하는 연결리스트로 구현하면 성능이 좋지 않다.
#### 단점
- 레코드를 배열(Array)로 구성하면, 임시 배열이 필요하다.
- 레코드의 길이가 길어질수록 이동 횟수가 많아져 비효율적이다. 
``` java
public void mergeSort(int[] array, int left, int right) {
    
    if(left < right) {
        int mid = (left + right) / 2;
        
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }
    
}

public static void merge(int[] array, int left, int mid, int right) {
    int[] L = Arrays.copyOfRange(array, left, mid + 1);
    int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
    
    int i = 0, j = 0, k = left;
    int ll = L.length, rl = R.length;
    
    while(i < ll && j < rl) {
        if(L[i] <= R[j]) {
            array[k] = L[i++];
        }
        else {
            array[k] = R[j++];
        }
        k++;
    }
    
    // remain
    while(i < ll) {
        array[k++] = L[i++];
    }
    while(j < rl) {
        array[k++] = R[j++];
    }
}

```
### 퀵 정렬(Quick Sort)
분할 정복 방법의 일종으로, 하나의 리스트를 원소중 하나인 피벗(pivot)을 기준으로 두 개의 비균등한 크기로 분할하고 피벗은 위치를 고정한다. 이 과정을 재귀적으로 반복하여 분할된 부분 리스트를 정렬한다. 정렬된 부분 리스트를 합쳐 전체를 정렬하는 알고리즘이다.

Quick Sort은 불안정 정렬에 속하며, 다른 원소와의 비교만으로 정렬을 수행하는 비교 정렬에 속한다. 
평균적으로 가장 빠른 정렬 알고리즘이며 JAVA에서 Arrays.sort()도 내부적으로 Dual Pivot Quick Sort로 구현


#### 시간 복잡도
- 평균 시간 복잡도는 O(nlogn)(재귀 호출 깊이 logN * 각 단계별 배열의 비교 연산 N)이다.
- 피벗 값이 최소나 최대값으로 지정되어 파티션이 나누어지지 않는 최악의 경우 시간 복잡도는 n^2이다. 
 - 레코드의 개수 n이 2의 거듭제곱이라고 가정(n=2^k)했을 때, 순환 호출의 깊이는 n
- 피벗을 어떻게 선택하는지가 성능을 좌우
- 
#### 공간 복잡도
주어진 배열 안에서 교환(swap)을 통해, 정렬이 수행되므로 O(n)이다.

#### 장점
- 퀵정렬은 불필요한 데이터의 이동을 줄이고 먼거리의 데이터를 교환하며, 한 번 결정된 피벗은 추후 연산에서 제외할 수 있기 때문에 다른 nlogn인 정렬 알고리즘 보다 빠르다.
- 추가적인 메모리 공간이 필요하지 않는다.

#### 단점
- 불안정 정렬(Unstable Sort) 이다.
- 정렬된 배열에 대해서는 Quick Sort의 불균형 분할에 의해 오히려 수행시간이 더 많이 걸린다.
``` java
public void quickSort(int[] array, int right, int left) {
    if (right <= left) {
      return;
    }
    
    /**
    // 최악의 경우, 개선 방법
    int mid = (left + right) / 2;
    swap(array, left, mid);
    */
    
    
    int r = right;
    int l = left;
    int pivot = array[left];
    
    while (r >= l) {
      while (array[l] < pivot) {
        l++;
      }
      while (array[r] > pivot) {
        r--;
      }
      if (r >= l) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
        l++;
        r--;
      }
    }
    
    array[left] = array[l];
    array[r] = pivot;
    
    quickSort(array, right, l);
    quickSort(array, r, left);
  }
```


### 힙 정렬(Heap Sort)
트리 중에서 부모 노드의 원소 값이 자식 노드의 원소 값보다 큰 완전 이진 트리인 힙(Heap)을 만들기 위한 정렬 방법

#### 시간 복잡도
최선, 평균, 최악의 시간 복잡도는 nlogn이다. 

#### 장점
- 최소값 또는 최대값을 찾기 유용하다.
#### 단점
- 불안정 정렬이다.

``` java
private void solve() {
    int[] array = { 230, 10, 60, 550, 40, 220, 20 };
 
    heapSort(array);
 
    for (int v : array) {
        System.out.println(v);
    }
}
 
public static void heapify(int array[], int n, int i) {
    int p = i;
    int l = i * 2 + 1;
    int r = i * 2 + 2;
 
    if (l < n && array[p] < array[l]) {
        p = l;
    }
 
    if (r < n && array[p] < array[r]) {
        p = r;
    }
 
    if (i != p) {
        swap(array, p, i);
        heapify(array, n, p);
    }
}
 
public static void heapSort(int[] array) {
    int n = array.length;
 
    // init, max heap
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(array, n, i);
    }
 
    // for extract max element from heap
    for (int i = n - 1; i > 0; i--) {
        swap(array, 0, i);
        heapify(array, i, 0);
    }
}
 
public static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}
```

