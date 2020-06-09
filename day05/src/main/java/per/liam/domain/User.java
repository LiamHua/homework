package per.liam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liam
 * @date 2020/6/2 09:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户实体
     */

    private String username;
    private int age;
}
