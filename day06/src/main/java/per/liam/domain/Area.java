package per.liam.domain;
import per.liam.domain.Area;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author liam
 * @date 2020/6/9 08:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    private int id;
    private String name;
    private int type;
    private int pid;
    private ArrayList<Area> children = new ArrayList<Area> ();

    public void setChildren(Area e) {
        System.out.println(e);
        this.children.add(e);
    }
}
