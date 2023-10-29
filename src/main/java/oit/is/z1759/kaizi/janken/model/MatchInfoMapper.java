package oit.is.z1759.kaizi.janken.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import java.util.ArrayList;

@Mapper
public interface MatchInfoMapper {

  @Select("SELECT * FROM MATCHINFO")
  ArrayList<MatchInfo> selectAllMatchInfo();

  @Insert("INSERT INTO matchinfo (user1,user2,user1Hand,isActive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive});")

  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo matchinfo);

}
