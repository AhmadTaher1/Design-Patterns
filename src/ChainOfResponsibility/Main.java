package ChainOfResponsibility;

public class Main {

    public static void main(String[] args) {
        Request request1=new Request(500, RequestType.LEVEL1);
        Request request2=new Request(500,RequestType.LEVEL2);
        Request request3=new Request(500,RequestType.LEVEL3);
        Director ahmed =new Director();
        VP taher =new VP();
        CEO yassen=new CEO();
        ahmed.setSuccessor(taher);
        taher.setSuccessor(yassen);

        ahmed.handleRequest(request1);
        ahmed.handleRequest(request2);
        ahmed.handleRequest(request3);


    }
}
