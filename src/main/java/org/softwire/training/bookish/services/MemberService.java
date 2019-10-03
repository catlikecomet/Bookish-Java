package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService extends DatabaseService{
    public List<Member> getAllMembers(){
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Members")
                .mapToBean(Member.class)
                .list()
        );
    }

    public void addMember(Member member) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO Members (Named) VALUE (:Named)")
                        .bind("Named", member.getNamed())
                        .execute()
        );
    }

    public void deleteMember(int userId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM Members WHERE UserId = :UserId")
                        .bind("UserId", userId)
                        .execute()
        );
    }

    public void editMember (Member member) {
        jdbi.useHandle( handle ->
                handle.createUpdate("UPDATE Members SET Named = :Named WHERE UserId = :UserId")
                        .bind("Named", member.getNamed())
                        .bind("UserId", member.getUserId())
                        .execute()
        );
    }
}
