public class Person {
    /*Объект класса получает имя, которое мы передаем через конструктор класса*/
    private String name;

    public String getName(){
        return this.name;
    }

    public Person(String Name){
        this.name = Name;
    }

    /*- Синхронизированный метод bow()
    * - получает в конструктор friend'а
    * - */
    public synchronized void bow(Person friend){
        System.out.println(this.name + ": " + friend.getName() + " поклонился");
        friend.bowBack(this);

    }

    public synchronized void bowBack(Person friend){
        System.out.println(this.name + ": " + friend.getName() + " поклонился в ответ");
    }

}

