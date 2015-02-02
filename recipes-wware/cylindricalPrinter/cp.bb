SUMMARY = "Cylindrical Printer"

SRC_URI = "git://github.com/wware/CylindricalPrinter.git;protocol=http;branch=rpi-stuff"

S = "${WORKDIR}/git"

LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${S}/README.md;md5=251f3fc27808ffe31b34a96ec2a5b46c"

RDEPENDS_${PN} = "bash python python-logging rpi-gpio fbida"

# 0e5d5a2b0fdf86939fa4ab39cd910d3328694a76 more makerfaire
# 7e97392cc300bd3c79ac74b0943b951204ce927b Remove Arduino, CherryPy stuff. Reinstate code for RPi.
# 914d44bcf224ecbcc2414a45f388f482a2310932 Generate slices on the macbook, pep8, other progress
# 41a3cf54ad5f3321fda7b0eec49c12d98554b478 startup script goes in /etc/rc5.d
# 1f940a906972edd7ce0a70d08273cd626e71463d README: fix the picture, add more text.
# ddf58519210f17e31077e3f7b6076412948d828b In yocto, python is actually python2.7
# 69df6da084373227eb55c6da914f6b1874abe679 more puttering
# bfac70eefbfef9004f4dfb6a6e94bfacd34c769d fbi is now in /usr/bin
# 6a0581276270ce6dd631cd65d18e23a64108dfa0 These aren't part of the RPi build.
# 22c80a51bc478ba91349ff5f4f17ffd70e7935c5 A bit more work on the startup script.
SRCREV = "22c80a51bc478ba91349ff5f4f17ffd70e7935c5"

FILES_${PN} += "/home/root/CylindricalPrinter/* /etc/init.d/rcS /mnt/usbstick/.placeholder"

do_install() {
    install -m 0755 -d ${D}/home/root/CylindricalPrinter
    install -m 0755 -d ${D}/etc/rc5.d
    install -m 0755 -d ${D}/mnt/usbstick
    cp -R ${S}/* ${D}/home/root/CylindricalPrinter
    cp -R ${S}/S80cylpri.sh ${D}/etc/rc5.d
    cp -R ${S}/software/etc_fstab ${D}/etc/fstab
    touch ${D}/mnt/usbstick/.placeholder
}
