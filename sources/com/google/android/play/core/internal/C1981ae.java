package com.google.android.play.core.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.ae */
public final class C1981ae<StateT> {

    /* renamed from: a */
    protected final Set<StateUpdatedListener<StateT>> f727a = new HashSet();

    /* renamed from: a */
    public final synchronized void mo33547a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f727a.add(stateUpdatedListener);
    }

    /* renamed from: a */
    public final synchronized void mo33548a(StateT statet) {
        for (StateUpdatedListener<StateT> onStateUpdate : this.f727a) {
            onStateUpdate.onStateUpdate(statet);
        }
    }

    /* renamed from: b */
    public final synchronized void mo33549b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f727a.remove(stateUpdatedListener);
    }
}
