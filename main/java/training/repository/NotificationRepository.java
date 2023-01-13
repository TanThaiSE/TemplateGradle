package training.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import training.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {

  @Query(value="SELECT s.ID AS storeId,s.NAME AS storeName,n.ID AS notificationId,n.TITLE AS notificationTitle, "
      + "n.CONTENT AS notificationContent,(CASE WHEN nh.MEMBER_ID IS NULL THEN 'Moi' ELSE 'Da xem' END)  AS notificationStatus "
      + ",n.START_DATE AS notificationStartDate,n.END_DATE AS notificationEndDate,m.NAME AS memberName "
      + "FROM p_member m "
      + "INNER JOIN p_member_register_store mrs ON mrs.MEMBER_ID=m.ID "
      + "INNER JOIN p_store s ON s.ID=mrs.STORE_ID "
      + "INNER JOIN p_notification n ON n.STORE_ID=s.ID "
      + "LEFT JOIN p_notification_history nh ON nh.NOTIFICATION_ID=n.ID "
      + "WHERE m.ID=:memberId AND n.PUBLIC_STATUS=1 AND n.DELETE_FLAG=0 AND "
      + "((CURRENT_DATE BETWEEN n.START_DATE AND n.END_DATE) OR (CURRENT_DATE>=n.START_DATE and n.END_DATE IS NULL )"
      + " OR(CURRENT_DATE<=n.END_DATE and n.START_DATE IS NULL ) )",nativeQuery=true)
  public List<HashMap<String,?>> selectNotificationByMemberId(@Param("memberId") String memberId);
}
