package per.liam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liam
 * @date 2020/6/4 21:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    /**
     * 商品实体
     */
    private int pid;
    private String pname;
    private double shopPrice;
    private String pimage;
}
