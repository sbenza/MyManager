package com.example.vacao;

import java.util.List;
import com.example.vacao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table CATTLE.
 */
public class Cattle {

    private Long id;
    /** Not-null value. */
    private String stamp;
    private String comment;
    private String color;
    private String type;
    private String tag;
    private String horn;
    private String breed;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient CattleDao myDao;

    private List<VaccineControl> VaccineControl;
    private List<PalpationControl> PalpationControl;
    private List<InseminationControl> InseminationControl;
    private List<TaggingControl> TaggingControl;

    public Cattle() {
    }

    public Cattle(Long id) {
        this.id = id;
    }

    public Cattle(Long id, String stamp, String comment, String color, String type, String tag, String horn, String breed) {
        this.id = id;
        this.stamp = stamp;
        this.comment = comment;
        this.color = color;
        this.type = type;
        this.tag = tag;
        this.horn = horn;
        this.breed = breed;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCattleDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getStamp() {
        return stamp;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getHorn() {
        return horn;
    }

    public void setHorn(String horn) {
        this.horn = horn;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<VaccineControl> getVaccineControl() {
        if (VaccineControl == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VaccineControlDao targetDao = daoSession.getVaccineControlDao();
            List<VaccineControl> VaccineControlNew = targetDao._queryCattle_VaccineControl(id);
            synchronized (this) {
                if(VaccineControl == null) {
                    VaccineControl = VaccineControlNew;
                }
            }
        }
        return VaccineControl;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetVaccineControl() {
        VaccineControl = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<PalpationControl> getPalpationControl() {
        if (PalpationControl == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PalpationControlDao targetDao = daoSession.getPalpationControlDao();
            List<PalpationControl> PalpationControlNew = targetDao._queryCattle_PalpationControl(id);
            synchronized (this) {
                if(PalpationControl == null) {
                    PalpationControl = PalpationControlNew;
                }
            }
        }
        return PalpationControl;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetPalpationControl() {
        PalpationControl = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<InseminationControl> getInseminationControl() {
        if (InseminationControl == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            InseminationControlDao targetDao = daoSession.getInseminationControlDao();
            List<InseminationControl> InseminationControlNew = targetDao._queryCattle_InseminationControl(id);
            synchronized (this) {
                if(InseminationControl == null) {
                    InseminationControl = InseminationControlNew;
                }
            }
        }
        return InseminationControl;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetInseminationControl() {
        InseminationControl = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<TaggingControl> getTaggingControl() {
        if (TaggingControl == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaggingControlDao targetDao = daoSession.getTaggingControlDao();
            List<TaggingControl> TaggingControlNew = targetDao._queryCattle_TaggingControl(id);
            synchronized (this) {
                if(TaggingControl == null) {
                    TaggingControl = TaggingControlNew;
                }
            }
        }
        return TaggingControl;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetTaggingControl() {
        TaggingControl = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
