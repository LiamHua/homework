package per.liam.domain;

/**
 * @author liam
 * @date 2020/6/4 08:22
 */
public class Commodity {
    /**
     * 商品实体
     */
    private String id;
    private String name;
    private String introduction;
    private int price;
    private int number;

    public Commodity() {
    }

    public Commodity(String id, String name, String introduction, int price, int number) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.price = price;
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }
}
