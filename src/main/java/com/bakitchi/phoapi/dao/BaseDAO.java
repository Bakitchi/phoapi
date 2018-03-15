package com.bakitchi.phoapi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.bakitchi.phoapi.entity.TechBaseEntity;
import com.bakitchi.phoapi.entity.UserEntity;
import com.eharmony.pho.api.DataStoreApi;
import com.eharmony.pho.hbase.PhoenixHBaseDataStoreApiImpl;
import com.eharmony.pho.hbase.util.PhoenixConnectionManager;
import com.eharmony.pho.query.QuerySelect;
import com.eharmony.pho.query.builder.QueryBuilder;
import com.eharmony.pho.query.criterion.Restrictions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;
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
//        System.out.println(con.toString());
//        String sql="SELECT * FROM TEST2";
//        Statement statement =  con.createStatement();
//        ResultSet results =  statement.executeQuery(sql);
//        while(null!=results&&results.next()) {
//          System.out.println("id:" + results.getString(1) + "name:" + results.getString(2));
//        }
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }


  public void findOneUser(String id) throws Exception {
    final QuerySelect<UserEntity,UserEntity> query = QueryBuilder.builderFor(UserEntity.class).select().build();
    Iterable<UserEntity> entities = dataStoreApi.findAll(query);
    System.out.println(null == entities);
    System.out.println(entities);
    Iterator<UserEntity> iterator = entities.iterator();
    UserEntity userEntity = new UserEntity();
    System.out.println(iterator.next());
    while (iterator.hasNext()){
      userEntity = iterator.next();
    }
    System.out.println(userEntity.toString());

  }

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








  public static void main(String[] args) {

  }
}
