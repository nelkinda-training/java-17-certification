interface Stream<T> {
    <X> Stream<X> map(Function<T, X> mapping);

    static interface Builder {
    }
}

// StreamBuilder -> Stream.Builder
//
// inside Stream {
//      StreamBuilder -> Builder
// }
