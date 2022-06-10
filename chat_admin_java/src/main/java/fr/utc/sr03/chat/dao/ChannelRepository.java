package fr.utc.sr03.chat.dao;

import fr.utc.sr03.chat.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
    @Query("SELECT c FROM Channel c WHERE c.owner.id = :ownerId")
    List<Channel> findByOwner(@Param("ownerId") long ownerId);
}
