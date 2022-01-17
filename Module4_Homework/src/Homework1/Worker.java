package Homework1;

public class Worker {
    private String name;
    private int age;

    public Worker() {
    }

    public Worker(String name, int age) throws AgeException, NullException {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullException {
        if(name != null && name != ""){
            this.name = name;
        }else{
            throw new NullException("姓名不能为空！");
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if(age >= 18 && age <= 150){
            this.age = age;
        }else{
            throw new AgeException("年龄不合理！");
        }
    }
}
