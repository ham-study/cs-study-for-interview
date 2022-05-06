import java.util.Arrays;

public class 퀵정렬구현 {
	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		int pivot = partition(arr, low, high);
		// 해당 pivot 왼쪽 부분리스트와 오른쪽 부분리스트로 나눠 분할 정복
		quickSort(arr, low, pivot - 1);
		quickSort(arr, pivot + 1, high);
	}

	private static int partition(int[] arr, int left, int right) {
		// pivot을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬된 상태로 만든 후, pivot의 위치 반환
		int low = left;
		int high = right;
		int pivot = arr[left];	// 부분리스트의 왼쪽요소를 피벗으로 설정

		while (low < high) {
			// low가 high보다 크거나 같을 때까지 반복
			while (arr[high] > pivot && low < high) {
				// low가 high 이상이거나, high의 요소가 pivot 이하일 때까지 high 감소
				// 결국, high의 요소는 pivot 이하의 요소
				high--;
			}
			while (arr[low] <= pivot && low < high) {
				// low가 high 이상이거나, low의 요소가 pivot보다 커질 때까지 low 증가
				// 결국, low의 요소는 pivot 보다 큰 요소
				low++;
			}
			swap(arr, low, high);
		}
		swap(arr, left, low);	// 마지막으로 맨 처음 pivot으로 설정했던 위치의 원소와 low의 원소를 바꿈
		return low;	// 두 요소가 교환됐으면, pivot은 low의 요소이므로 low 반환
	}

	private static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
