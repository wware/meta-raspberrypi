SUMMARY = "Cylindrical Printer"
#SECTION = "libs"

SRC_URI = "git://github.com/wware/CylindricalPrinter.git;protocol=http;branch=master"

S = "${WORKDIR}/git"

LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${S}/README.md;md5=5bf216df125104b135e7a2295b982479"

DEPENDS = "python"

# 8980ae204e5e1503b2efab7cf8c7eb0442e76d03 Add stepper polarity bit. Thought I'd already done this.
# 97780861b8af6c0e666f5d27069849126e6cac0f bug fix, and scriptability
# 41f85aabea0444c0a008221774df91b1b73c243b RPi stuff, and config stuff
# 5467d366137987925fbf13f7aebe318f2541acbc Discussing change of direction.
# b811333bbc9df998d893c2e45d2abb1f389cb266 Fix Arduino bugs, use the Arduino to control the stepper.
# a32ec52d0c2c6e9cbe2297dea6488ae7cf42409d More conservative design for sprocket tooth.
# 87735c5b64eddea1fc87fc8f061f64ea4880c24b Remove Raspberry Pi stuff. Clean stuff up.
# 5926a693e3e99ad8be066ec28f08e60f707a66a8 cleanup, refactoring, remove mirror supports
# cf4b1f597e709bff148b8f22cb1e03c54dbea157 Gallery of photos
# 7b91839d1882577544798306dd448625cbdae072 Update some of the READMEs.
SRCREV = "7b91839d1882577544798306dd448625cbdae072"

FILES_${PN} += "/CP/*"

do_install() {
    install -m 0755 -d ${D}/CP
    cp -R ${S}/* ${D}/CP
}
