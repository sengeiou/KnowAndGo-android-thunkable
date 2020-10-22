package expo.modules.updates.launcher;

import expo.modules.updates.p021db.entity.UpdateEntity;
import java.util.List;

public interface SelectionPolicy {
    UpdateEntity selectUpdateToLaunch(List<UpdateEntity> list);

    List<UpdateEntity> selectUpdatesToDelete(List<UpdateEntity> list, UpdateEntity updateEntity);

    boolean shouldLoadNewUpdate(UpdateEntity updateEntity, UpdateEntity updateEntity2);
}
