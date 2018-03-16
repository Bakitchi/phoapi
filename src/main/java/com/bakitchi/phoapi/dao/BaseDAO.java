package com.bakitchi.phoapi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.bakitchi.phoapi.dto.CollegeDTO;
import com.bakitchi.phoapi.dto.TeacherBasicInfoDTO;
import com.bakitchi.phoapi.entity.*;
import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.hbase.PhoenixHBaseDataStoreApiImpl;
import com.eharmony.pho.hbase.query.PhoenixHBaseQueryExecutor;
import com.eharmony.pho.hbase.util.PhoenixConnectionManager;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.QueryUpdate;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.builder.QueryUpdateBuilder;
import com.eharmony.pho.query.criterion.Ordering;
import com.eharmony.pho.query.criterion.Restrictions;
import com.eharmony.pho.query.criterion.junction.Disjunction;
import com.google.common.collect.Lists;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import javax.management.Query;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/14 下午1:23
 * @Description:
 */


@Repository
@ImportResource(locations = {"h-config.xml"})
public class BaseDAO {
  private static final String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
  private static final String url="jdbc:phoenix:47.94.107.19:2181";
  private static Connection con=null;

  public DataStoreApi getDataStoreApi() {
    return dataStoreApi;
  }

  @Autowired
  DataStoreApi dataStoreApi;

//  @Autowired
//  PhoenixHBaseQueryExecutor phoenixHBaseQueryExecutor;
//
//
//  /**
//   *@Description: 连接数据库
//   *@Name:  static initializer
//   *@Param:
//   *@Return:
//   *@Author:  Bakitchi
//   *@Created-Time:  2018/3/14 下午1:30
//   */
//  static {
//    try {
//      con = PhoenixConnectionManager.getConnection(url);
//      if (null != con) {
//        System.out.println("连接成功！");
//
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }

//
//  public void findOneUser(String id) throws Exception {
//    final QuerySelect<UserEntity,UserEntity> query = QueryBuilder.builderFor(UserEntity.class).select().build();
//    Iterable<UserEntity> entities = dataStoreApi.findAll(query);
//    System.out.println(null == entities);
//    System.out.println(entities);
//    Iterator<UserEntity> iterator = entities.iterator();
//    UserEntity userEntity = new UserEntity();
//    System.out.println(iterator.next());
//    while (iterator.hasNext()){
//      userEntity = iterator.next();
//    }
//    System.out.println(userEntity.toString());
//
//  }

  public TechBaseEntity daoGetTeacherInfo(Integer id){
    final QuerySelect<TechBaseEntity,TechBaseEntity> query = QueryBuilder.builderFor(TechBaseEntity.class).select()
      .add(Restrictions.eq("\"id\"", id)).build();

    Iterable<TechBaseEntity> entities = dataStoreApi.findAll(query);
    Iterator<TechBaseEntity> iterator = entities.iterator();
    return iterator.next();
  }


  public TechBaseEntity daoGetTeacherInfoByName(String  name){
    final QuerySelect<TechBaseEntity,TechBaseEntity> query = QueryBuilder.builderFor(TechBaseEntity.class).select()
            .add(Restrictions.eq("\"name\"", name)).build();

    Iterable<TechBaseEntity> entities = dataStoreApi.findAll(query);
    Iterator<TechBaseEntity> iterator = entities.iterator();
    return iterator.next();
  }

  //上面的都没用……⤴
  /**
   *@Description:根据教师ID查找教师信息与所发论文
   *@Name:  daoGetTeacherInfoById
   *@Param:  [id]
   *@Return:  com.bakitchi.phoapi.dto.TeacherBasicInfoDTO
   *@Author:  Bakitchi
   *@Created-Time:  2018/3/15 下午2:46
   */
  public TeacherBasicInfoDTO daoGetTeacherInfoById(Integer id){

    final QuerySelect<TechAllEntity,TechAllEntity> query = QueryBuilder.builderFor(TechAllEntity.class).select()
            .add(Restrictions.eq("ID", id)).build();

    TechAllEntity techAllEntity = dataStoreApi.findOne(query);
    TeacherBasicInfoDTO teacherBasicInfoDTO = new TeacherBasicInfoDTO();
    //构建数据传输对象
    teacherBasicInfoDTO.setTechAllEntity(techAllEntity);
    teacherBasicInfoDTO.setPapersList(daoGetPapersInfoByTeacherName(techAllEntity.getName()));
    return  teacherBasicInfoDTO;
  }

  /**
   *@Description:根据论文含有的作者返回该作者发表的论文集合
   *@Name:  daoGetPapersInfoByTeacherName
   *@Param:  [name]
   *@Return:  java.util.List<com.bakitchi.phoapi.entity.PapersInfoEntity>
   *@Author:  Bakitchi
   *@Created-Time:  2018/3/15 下午2:47
   */
  public List<PapersInfoEntity> daoGetPapersInfoByTeacherName(String name){

    final QuerySelect<PapersInfoEntity,PapersInfoEntity> query = QueryBuilder.builderFor(PapersInfoEntity.class).select()
            .add(Restrictions.like("AUTHORS", name)).build();
    Iterable<PapersInfoEntity> entities = dataStoreApi.findAll(query);
    List<PapersInfoEntity> papersList = new ArrayList<>();
    entities.forEach(single->papersList.add(single));

    return  papersList;
  }

  /**
   *@Description:发送学院ID，获取该学院的所有教师信息（基本信息）
   *@Name:  daoGetTeacherInfoByCollegeId
   *@Param:  [id]
   *@Return:  java.util.List<com.bakitchi.phoapi.entity.TechAllEntity>
   *@Author:  Bakitchi
   *@Created-Time:  2018/3/15 下午4:38
   */
  public List<TechAllEntity> daoGetTeacherInfoByCollegeId(Integer id){
    //获取学院名字
    String college = daoGetCollegeNameByCollegeId(id);
    final QuerySelect<TechAllEntity,TechAllEntity> query = QueryBuilder.builderFor(TechAllEntity.class).select()
            .add(Restrictions.eq("COLLEGE", college)).build();
    Iterable<TechAllEntity> entities = dataStoreApi.findAll(query);
    Iterator<TechAllEntity> iterator = entities.iterator();
    //构建TeacherList
    List<TechAllEntity> teachers = new ArrayList<TechAllEntity>();
    entities.forEach(single->teachers.add(single));
    return teachers;
  }


  /**
   *@Description:根据学院ID获得学院名称
   *@Name:  daoGetCollegeNameByCollegeId
   *@Param:  [id]
   *@Return:  java.lang.String
   *@Author:  Bakitchi
   *@Created-Time:  2018/3/15 下午4:39
   */
  public String daoGetCollegeNameByCollegeId(Integer id){
    final QuerySelect<CollegeNodesEntity,CollegeNodesEntity> query = QueryBuilder.builderFor(CollegeNodesEntity.class).select()
            .add(Restrictions.eq("ID", id)).build();
    CollegeNodesEntity collegeNodesEntity = dataStoreApi.findOne(query);
    return collegeNodesEntity.getCollege();
  }

    /**
     *@Description:根据教师ID获取教师实体
     *@Name:  daoGetTeacherEntityByTeacherId
     *@Param:  [id]
     *@Return:  com.bakitchi.phoapi.entity.TechAllEntity
     *@Author:  Bakitchi
     *@Created-Time:  2018/3/15 下午9:20
     */
    public TechAllEntity daoGetTeacherEntityByTeacherId(Integer id){
        final QuerySelect<TechAllEntity,TechAllEntity> query = QueryBuilder.builderFor(TechAllEntity.class).select()
                .add(Restrictions.eq("ID", id)).build();
        return dataStoreApi.findOne(query);
    }


  /**
   *@Description:根据教师ID返回教师访问量
   *@Name:  daoGetVisitByTeacherId
   *@Param:  [id]
   *@Return:  java.lang.Integer
   *@Author:  Bakitchi
   *@Created-Time:  2018/3/15 下午6:52
   */
  public Integer daoGetVisitByTeacherId(Integer id){
    return daoGetTeacherEntityByTeacherId(id).getVisit();
  }

    /**
     *@Description:根据教师ID更新教师访问量（每次请求则+1）
     *@Name:  daoUpdateVisitByTeacherId
     *@Param:  [id]
     *@Return:  void
     *@Author:  Bakitchi
     *@Created-Time:  2018/3/15 下午9:22
     */
  public void daoUpdateVisitByTeacherId(Integer id){
    TechAllEntity techAllEntity = daoGetTeacherEntityByTeacherId(id);
    techAllEntity.setVisit(techAllEntity.getVisit()+1);
    dataStoreApi.save(techAllEntity);
  }

  /**
   *@Description:获得访问量最多的十个教师List
   *@Name:  daoGetMostVisitTeacher
   *@Param:  []
   *@Return:  java.util.List<com.bakitchi.phoapi.entity.TechAllEntity>List
   *@Author:  Bakitchi
   *@Created-Time:  2018/3/16 上午9:47
   */
  public List<TechAllEntity> daoGetMostVisitTeacher(){

    final QuerySelect<TechAllEntity,TechAllEntity> query = QueryBuilder.builderFor(TechAllEntity.class).select()
            .setMaxResults(10).addOrder(new Ordering("VISIT", Ordering.Order.DESCENDING, Ordering.NullOrdering.FIRST)).build();

    Iterable<TechAllEntity> entities = dataStoreApi.findAll(query);
    List<TechAllEntity> techAllEntityList = new ArrayList<>();
    entities.forEach(single->techAllEntityList.add(single));
    return techAllEntityList;
  }

  //"yyyy-MM-dd HH:MM:ss"
  /**
   *@Description:获取最近修改的十个教师List
   *@Name:  daoGetRecentModifyTeacher
   *@Param:  []
   *@Return:  java.util.List<com.bakitchi.phoapi.entity.TechAllEntity>
   *@Author:  Bakitchi
   *@Created-Time:  2018/3/16 上午10:22
   */
  public List<TechAllEntity> daoGetRecentModifyTeacher() throws ParseException {

    final QuerySelect<TechAllEntity,TechAllEntity> query = QueryBuilder.builderFor(TechAllEntity.class).select()
            .setMaxResults(10).addOrder(new Ordering("TIME", Ordering.Order.DESCENDING, Ordering.NullOrdering.FIRST)).build();

    Iterable<TechAllEntity> entities = dataStoreApi.findAll(query);
    List<TechAllEntity> techAllEntityList = new ArrayList<>();
    entities.forEach(single->techAllEntityList.add(single));
    return techAllEntityList;
  }


  /**
   *@Description:获得所有学院
   *@Name:  daoGetAllCollege
   *@Param:  []
   *@Return:  java.util.List<com.bakitchi.phoapi.dto.CollegeDTO>
   *@Author:  Bakitchi
   *@Created-Time:  2018/3/16 上午10:37
   */
  public List<CollegeDTO> daoGetAllCollege(){

    final QuerySelect<CollegeNodesEntity,CollegeNodesEntity> query = QueryBuilder.builderFor(CollegeNodesEntity.class).select().build();

    Iterable<CollegeNodesEntity> entities = dataStoreApi.findAll(query);
    Iterator<CollegeNodesEntity> iterator = entities.iterator();
    List<CollegeDTO> collegeList = new ArrayList<CollegeDTO>();
    List<CollegeNodesEntity> collegeNodesEntities = new ArrayList<CollegeNodesEntity>();
    entities.forEach(single->collegeNodesEntities.add(single));
    for (CollegeNodesEntity collegeNodesEntity : collegeNodesEntities){
        CollegeDTO collegeDTO = new CollegeDTO();
        collegeDTO.setName(collegeNodesEntity.getCollege());
        collegeDTO.setInstitutionID(collegeNodesEntity.getId());
        collegeList.add(collegeDTO);
    }
//    while (iterator.hasNext()) {
//      CollegeDTO collegeDTO = new CollegeDTO();
//      collegeDTO.setInstitutionID(iterator.next().getId());
//      collegeDTO.setName(iterator.next().getCollege());
//      collegeList.add(collegeDTO);
//    }
    return collegeList;
  }


    /**
     *@Description: 发送查询字符串和查询类别 获得查询结果
     *@Name:  daoQueryTeacher
     *@Param:  [typ, wd]
     *@Return:  java.util.List<com.bakitchi.phoapi.entity.TechAllEntity>
     *@Author:  Bakitchi
     *@Created-Time:  2018/3/16 下午12:55
     */
  public List<TechAllEntity> daoQueryTeacher(String typ, String wd){

      QuerySelect<TechAllEntity,TechAllEntity> query = null;
      switch (typ) {
          case "NAME":
              query = QueryBuilder.builderFor(TechAllEntity.class).select()
                      .add(Restrictions.eq("NAME", wd)).build();
              break;

          case "DIRECTION":
              query = QueryBuilder.builderFor(TechAllEntity.class).select()
                      .add(Restrictions.like("DIRECTION", wd)).build();
              break;

          case "ABSTRACT":
              query = QueryBuilder.builderFor(TechAllEntity.class).select()
                      .add(Restrictions.like("ABSTRACT", wd)).build();
              break;

          default:
              break;

      }

      if (null == query){
          return null;
      }

      Iterable<TechAllEntity> entities = dataStoreApi.findAll(query);
      List<TechAllEntity> teacherList = new ArrayList<>();
      entities.forEach(single->teacherList.add(single));

      return teacherList;
  }

    /**
     *@Description: 获得所有大类学科
     *@Name:  daoGetAllSubjects
     *@Param:  []
     *@Return:  java.util.List<java.lang.String>
     *@Author:  Bakitchi
     *@Created-Time:  2018/3/16 下午2:17
     */
  public List<String> daoGetAllSubjects(){

      final QuerySelect<TechSubjectEntity,TechSubjectEntity> query = QueryBuilder.builderFor(TechSubjectEntity.class).
              select().build();
      Iterable<TechSubjectEntity> entities = dataStoreApi.findAll(query);
      List<TechSubjectEntity> techSubjectEntities = new ArrayList<>();
      entities.forEach(single->techSubjectEntities.add(single));
      List<String> cList = new ArrayList<>();
      for (TechSubjectEntity techSubjectEntity:entities){
          cList.add(techSubjectEntity.getBelong());
      }

      StringBuffer sb = new StringBuffer();
      for (String str:cList){
          sb.append(str);
      }

      String str2 = sb.toString();

      String[] strArr = str2.split(";");

      List<String> strListD = Arrays.asList(strArr);

      List newList = new ArrayList(new HashSet(strListD));
      return newList;
  }

    /**
     *@Description:更新教师基本信息
     *@Name:  daoUpdateAbstract
     *@Param:  [id, info]
     *@Return:  void
     *@Author:  Bakitchi
     *@Created-Time:  2018/3/16 下午2:18
     */
  public void daoUpdateAbstract(Integer id,String info){
      TechAllEntity techAllEntity = daoGetTeacherEntityByTeacherId(id);
      techAllEntity.setAbstractinfo(info);
      SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
      techAllEntity.setTime(Long.valueOf(df.format(new Date())));
      dataStoreApi.save(techAllEntity);
  }

    /**
     *@Description:更新教师项目
     *@Name:  daoUpdateTeacherPro
     *@Param:  [id, info]
     *@Return:  void
     *@Author:  Bakitchi
     *@Created-Time:  2018/3/16 下午2:19
     */
  public void daoUpdateTeacherPro(Integer id,String info){
      TechAllEntity techAllEntity = daoGetTeacherEntityByTeacherId(id);
      techAllEntity.setProject(info);
      SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
      techAllEntity.setTime(Long.valueOf(df.format(new Date())));
      dataStoreApi.save(techAllEntity);
  }


    /**
     *@Description:更新教师招生信息
     *@Name:  daoUpdateTeacherWanted
     *@Param:  [id, info]
     *@Return:  void
     *@Author:  Bakitchi
     *@Created-Time:  2018/3/16 下午2:19
     */
  public void daoUpdateTeacherWanted(Integer id,String info){
      TechAllEntity techAllEntity = daoGetTeacherEntityByTeacherId(id);
      techAllEntity.setWanted(info);
      SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
      techAllEntity.setTime(Long.valueOf(df.format(new Date())));
      dataStoreApi.save(techAllEntity);
  }


}
