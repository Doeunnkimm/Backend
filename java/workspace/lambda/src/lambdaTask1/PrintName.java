package lambdaTask1;

@FunctionalInterface
public interface PrintName {
	public abstract String getFullName(String lastName, String firstName);
}
