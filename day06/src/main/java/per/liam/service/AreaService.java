package per.liam.service;

import com.google.gson.Gson;
import per.liam.dao.AreaDao;
import per.liam.domain.Area;

import java.util.HashMap;
import java.util.List;

/**
 * @author liam
 * @date 2020/6/9 08:32
 */
public class AreaService {
    public String getArea() {
        AreaDao areaDao = new AreaDao();
        List<Area> areaList = areaDao.getArea();
        HashMap<Integer, Area> provinceMap = new HashMap<>();
        for (Area e : areaList) {
            if (e.getType() == 1) {
                provinceMap.put(e.getId(), e);
            }
        }
        for (Area e : areaList) {
            if (e.getType() == 2) {
                provinceMap.get(e.getPid()).setChildren(e);
            }
        }
        String s = new Gson().toJson(provinceMap);
        System.out.println(s);
        return s;
    }
}
