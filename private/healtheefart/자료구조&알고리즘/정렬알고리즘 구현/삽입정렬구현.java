import java.util.Arrays;

public class 삽입정렬구현 {
	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int target = arr[i];	// target은 두번째 원소부터
			int leftIdx = i - 1;

			while (leftIdx >= 0 && target < arr[leftIdx]) {
				// target이 이전 원소보다 크거나 같을 때까지 반복
				arr[leftIdx + 1] = arr[leftIdx];
				// target이 이전 원소보다 작으면 서로 위치교환
				leftIdx--;
			}
			arr[leftIdx + 1] = target;
			// 앞의 원소가 타겟보다 작으니 타겟은 leftIdx + 1에 위치
		}
	}
}
