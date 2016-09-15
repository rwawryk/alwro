package edu.alwro.disks

import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchDisksAlgorithmTest extends Specification {

    // Test data http://main.edu.pl/pl/user.phtml?op=zasoby

    @Unroll
    def "BinarySearchDisksAlgorithm for #input"() {
        given: "input data"
        String inputPath = this.getClass().getResource(input).path

        when: "algorithm is executed"
        int result = BinarySearchDisksAlgorithm.run(inputPath)

        then: "result should match expected value"
        int expectedResult = this.getClass().getResource(output).text.toInteger()
        result == expectedResult - 1

        where:
        input                || output
        '/disks/kra0.in'     || '/disks/kra0.out'
        '/disks/kra1a.in'    || '/disks/kra1a.out'
        '/disks/kra1b.in'    || '/disks/kra1b.out'
        '/disks/kra1ocen.in' || '/disks/kra1ocen.out'
        '/disks/kra2.in'     || '/disks/kra2.out'
        '/disks/kra2ocen.in' || '/disks/kra2ocen.out'
        '/disks/kra3a.in'    || '/disks/kra3a.out'
        '/disks/kra3b.in'    || '/disks/kra3b.out'
        '/disks/kra3ocen.in' || '/disks/kra3ocen.out'
        '/disks/kra4.in'     || '/disks/kra4.out'
        '/disks/kra4ocen.in' || '/disks/kra4ocen.out'
        '/disks/kra5.in'     || '/disks/kra5.out'
        '/disks/kra6.in'     || '/disks/kra6.out'
        '/disks/kra7.in'     || '/disks/kra7.out'
        '/disks/kra8.in'     || '/disks/kra8.out'
        '/disks/kra9.in'     || '/disks/kra9.out'
        '/disks/kra10.in'    || '/disks/kra10.out'
        '/disks/kra11.in'    || '/disks/kra11.out'
    }
}
