import java.util.Arrays;
import java.util.PriorityQueue;

public class 힙정렬구현 {
	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		heapSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr, int size) {
		if (size < 2) {
			// 부모노드와 heaify 과정에서 음수가 발생하면 잘못 된 참조가 발생하기 때문에
			// 원소가 1개이거나 0개일 경우는 정렬 할 필요가 없으므로 바로 함수를 종료한다.
			return;
		}

		int parentIdx = getParent(size - 1);	// 가장 마지막 요소의 부모 인덱스
		for (int i = parentIdx; i >= 0; i--) {
			// maxHeap
			heapify(arr, i, size - 1);
		}

		for (int i = size - 1; i > 0; i--) {
			// root인 0번째 idx와 i번째 idx의 값을 교환해준 뒤, 0~(i-1)까지의 부분 트리에 대해 max heap을 만족하도록 재구성
			swap(arr, 0, i);
			heapify(arr, 0, i - 1);
		}
	}

	private static void heapify(int[] arr, int parentIdx, int lastIdx) {
		// 힙을 재구성 하는 함수
		int leftChildIdx = 2 * parentIdx + 1;
		int rightChildIdx = 2 * parentIdx + 2;
		int largestIdx = parentIdx;
		// 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
		// 현재 부모 인덱스 요소가 가장 큰 값을 갖고 있다고 가정

		if (leftChildIdx <= lastIdx && arr[largestIdx] < arr[leftChildIdx]) {
			// 자식노드 idx가 트리의 크기를 넘어가지 않으면서
			// 현재 가장 큰 요소보다 왼쪽 자식노드의 값이 더 크면, 가장 큰 인덱스를 왼쪽 자식노드 idx로
			largestIdx = leftChildIdx;
		}
		if (rightChildIdx <= lastIdx && arr[largestIdx] < arr[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}

		if (parentIdx != largestIdx) {
			// 부모노드보다 큰 자식노드가 있으면
			// 해당 자식 노드와 부모노드를 교환하고, 교환된 자식노드를 부모노드로 삼은 서브트리 검사
			swap(arr, largestIdx, parentIdx);
			heapify(arr, largestIdx, lastIdx);
		}
	}

	private static int getParent(int child) {
		// 부모 인덱스를 얻는 함수
		return (child - 1) / 2;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
