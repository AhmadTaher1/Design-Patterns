package ChainOfResponsibility;


//extendable can put anyone new in the chain without changing a lot

//decoupled sender and reciever

//sender don't know exactly who handled his request

//cons

//performance issues in long chains msh bb3t al7aga lly hihndlha 3la tol











class Request{

    int amount;
    RequestType requestType;

    public Request(int amount, RequestType requestType) {
        this.amount = amount;
        this.requestType = requestType;
    }
}


public abstract class Handler {

    Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Request request);



}


class Director extends Handler{


    @Override
    public void handleRequest(Request request) {
        if(request.requestType==RequestType.LEVEL1){
            System.out.println("i can handle this as director");
        }
        else{
            successor.handleRequest(request);
        }
    }
}

class VP extends Handler{


    @Override
    public void handleRequest(Request request) {
        if(request.requestType==RequestType.LEVEL2){
            System.out.println("i can handle this as vice president");
        }
        else{

            successor.handleRequest(request);
        }
    }
}

class CEO extends Handler{


    @Override
    public void handleRequest(Request request) {

            System.out.println("i can handle this as ChainOfResponsibility.CEO");
    }
}
