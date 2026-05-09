package javaDSA.logicBuildingProblems;

public class AddComplexNumber {

    int real, image;

    public AddComplexNumber(int r, int i){
        this.real =  r;
        this.image = i;
    }

    public void show(){
        System.out.println(this.real +"+ i" + this.image);
    }

    public static AddComplexNumber add(AddComplexNumber n1, AddComplexNumber n2){
        AddComplexNumber addComp = new AddComplexNumber(0,0);
        addComp.real = n1.real + n2.real;
        addComp.image = n1.image + n2.image;
        return  addComp;
    }
}
