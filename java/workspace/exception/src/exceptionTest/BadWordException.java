package exceptionTest;

// Exception�� �����Ϸ��� üũ <- ���� ���� �ϱ� ����
// RuntimeException�� �����Ϸ��� �˻����� �ʱ� ������ try/catch �϶�� ���� ����(���� �Ǵ� ��Ÿ�� ����)
// ���� ������ ���� ���� ��Ű�� �ʹٸ� try/catch�� �������ƾ� �ϹǷ�
// RuntimeException�� ����ؾ� ��

public class BadWordException extends RuntimeException /* Exception */ {
	public BadWordException(String message) {
		// �ܼ�â�� message�� ����ְԵ�
		super(message); // �θ��� �����ڿ� message�� ����
	}
}
