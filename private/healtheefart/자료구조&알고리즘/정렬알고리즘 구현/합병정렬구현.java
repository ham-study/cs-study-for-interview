import java.util.Arrays;

public class 합병정렬구현 {
	static int[] arr;
	public static void main(String[] args) {
		arr = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		mergeSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int left, int right) {
		// 나누는 함수
		if (left < right) {
			// 나눈 배열의 원소수가 2개 이상일 때
			int mid = (left + right) / 2;
			mergeSort(left, mid);	// 왼쪽 배열 다시 나누기
			mergeSort(mid + 1, right);	// 오른쪽 배열 다시 나누기

			merge(left, mid, right);	// 병합과정
		}
	}

	private static void merge(int left, int mid, int right) {
		// 분할된 왼쪽 리스트의 인덱스가 mid까지 온 경우 왼쪽 정렬 완료
		// 분할된 오른쪽 리스트의 인덱스가 right까지 온 경우 오른쪽 정렬 완료
		// 즉, 왼쪽 또는 오른쪽 둘 중 하나라도 정렬이 완료된 경우 반복문을 빠져나감
		int leftIdxOfLeft = left;	// 분할된 왼쪽 리스트들의 시작점 변수
		int leftIdxOfRight = mid + 1;	// 분할된 오른쪽 리스트들의 시작점 변수
		int sortedIdx = left;	// 정렬된 데이터가 저장될 인덱스
		int[] sorted = new int[arr.length];

		while (leftIdxOfLeft <= mid && leftIdxOfRight <= right) {
			if (arr[leftIdxOfLeft] <= arr[leftIdxOfRight]) {
				sorted[sortedIdx] = arr[leftIdxOfLeft];
				sortedIdx++; leftIdxOfLeft++;
			} else {
				sorted[sortedIdx] = arr[leftIdxOfRight];
				sortedIdx++; leftIdxOfRight++;
			}
		}

		if (leftIdxOfLeft > mid) {
			for (int i = leftIdxOfRight; i <= right; i++) {
				sorted[sortedIdx++] = arr[i];
			}
		} else {
			for (int i = leftIdxOfLeft; i <= mid; i++) {
				sorted[sortedIdx++] = arr[i];
			}
		}

		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}
}
