public class MyService {

    public void performOperation() throws MyCheckedException {
        // 业务逻辑
        boolean errorOccurred = true; // 示例条件

        if (errorOccurred) {
            throw new MyCheckedException("An error occurred during the operation.");
        }
    }
}
