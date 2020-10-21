package kotlin.sequences;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, mo39786d2 = {"kotlin/sequences/SequencesKt___SequencesKt$sorted$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: _Sequences.kt */
public final class SequencesKt___SequencesKt$sorted$1 implements Sequence<T> {
    final /* synthetic */ Sequence $this_sorted;

    SequencesKt___SequencesKt$sorted$1(Sequence<? extends T> sequence) {
        this.$this_sorted = sequence;
    }

    @NotNull
    public Iterator<T> iterator() {
        List mutableList = SequencesKt.toMutableList(this.$this_sorted);
        CollectionsKt.sort(mutableList);
        return mutableList.iterator();
    }
}
