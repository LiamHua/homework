package per.liam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liam
 * @date 2020/6/4 21:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    /**
     * 商品分类
     */
    private int id;
    private String cname;
}
