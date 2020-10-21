package expo.modules.updates.launcher;

import expo.modules.updates.p021db.entity.UpdateEntity;
import java.util.ArrayList;
import java.util.List;

public class SelectionPolicyNewest implements SelectionPolicy {
    private String mRuntimeVersion;

    public SelectionPolicyNewest(String str) {
        this.mRuntimeVersion = str;
    }

    public UpdateEntity selectUpdateToLaunch(List<UpdateEntity> list) {
        UpdateEntity updateEntity = null;
        for (UpdateEntity next : list) {
            if (this.mRuntimeVersion.equals(next.runtimeVersion) && (updateEntity == null || updateEntity.commitTime.before(next.commitTime))) {
                updateEntity = next;
            }
        }
        return updateEntity;
    }

    public List<UpdateEntity> selectUpdatesToDelete(List<UpdateEntity> list, UpdateEntity updateEntity) {
        if (updateEntity == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (UpdateEntity next : list) {
            if (next.commitTime.before(updateEntity.commitTime)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean shouldLoadNewUpdate(UpdateEntity updateEntity, UpdateEntity updateEntity2) {
        if (updateEntity2 == null) {
            return true;
        }
        if (updateEntity == null) {
            return false;
        }
        return updateEntity.commitTime.after(updateEntity2.commitTime);
    }
}
