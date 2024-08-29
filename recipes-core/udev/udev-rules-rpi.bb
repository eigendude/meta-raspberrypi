DESCRIPTION = "udev rules for Raspberry Pi Boards"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	git://github.com/RPi-Distro/raspberrypi-sys-mods;protocol=https;nobranch=1 \
	file://can.rules \
	file://fb.rules \
	"
SRCREV = "6efcf2eaae743311533da036a3852f8a5335cc3e"

S = "${WORKDIR}/git"

INHIBIT_DEFAULT_DEPS = "1"

do_install () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${S}/etc.armhf/udev/rules.d/99-com.rules ${D}${sysconfdir}/udev/rules.d/
    install -m 0644 ${WORKDIR}/can.rules ${D}${sysconfdir}/udev/rules.d/
    install -m 0644 ${WORKDIR}/fb.rules ${D}${sysconfdir}/udev/rules.d/
}
