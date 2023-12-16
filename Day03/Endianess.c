#include <assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdint.h>

#define BYTE_ORDER_MARK 0xFFFE

int main() {
    union {
        uint16_t bom;
        uint8_t endianDetect[2];
    } cauldron;
    cauldron.bom = BYTE_ORDER_MARK;
    switch (cauldron.endianDetect[0]) {
    case 0xFF: puts("Big Endian"); break;
    case 0xFE: puts("Little Endian"); break;
    default: assert(false);
    }
}
