class Example {
    public static void main(final String... args) {
        try (Stream<IPPFileElement> fileStream = ippFile.getFileElements().stream()) {
            config.PIN = fileStream
                .filter(element -> ((IPPFileElementDGI)element).getDgi().getTag().matches(TAG_PIN_BLOCK))
                .map(element -> ((IPPFileElementDGI)element).getDgi().getValue())
                .findAny()
                .get();

            ByteString desKey = fileStream
                .filter(element -> ((IPPFileElementDGI)element).getDgi().getTag().matches(TAG_DES_KEY))
                .map(element -> ((IPPFileElementDGI)element).getDgi().getValue())
                .findAny()
                .get();
        }
    }

    public static ByteString getDesKey(final IPPFile ippFile) {
        try (Stream<IPPFileElement> fileStream = ippFile.getFileElements().stream()) {
            return fileStream
                .filter(element -> ((IPPFileElementDGI)element).getDgi().getTag().matches(TAG_DES_KEY))
                .map(element -> ((IPPFileElementDGI)element).getDgi().getValue())
                .findAny()
                .get();
        }
    }
    public static String getConfigPin(final IPPFile ippFile) {
        try (Stream<IPPFileElement> fileStream = ippFile.getFileElements().stream()) {
            return fileStream
                .filter(element -> ((IPPFileElementDGI)element).getDgi().getTag().matches(TAG_PIN_BLOCK))
                .map(element -> ((IPPFileElementDGI)element).getDgi().getValue())
                .findAny()
                .get();
        }
    }
}
