package leetcode;

class No2529 {

    public static void main(String[] args) {
        No2529 no = new No2529();
        int i = no.maximumCount(new int[]{
                -1998, -1998, -1996, -1996, -1994, -1994, -1994, -1992, -1988, -1986, -1986, -1985, -1984, -1984, -1982, -1981, -1981, -1981, -1980, -1977, -1977, -1976, -1976, -1974, -1971, -1965, -1964, -1963, -1959, -1959, -1955, -1952, -1950, -1942, -1936, -1933, -1933, -1930, -1930, -1927, -1925, -1923, -1919, -1917, -1917, -1913, -1911, -1910, -1908, -1907, -1905, -1904, -1902, -1900, -1898, -1894, -1892, -1891, -1884, -1884, -1883, -1883, -1882, -1882, -1880, -1878, -1875, -1872, -1872, -1870, -1869, -1868, -1868, -1867, -1867, -1864, -1854, -1854, -1850, -1849, -1848, -1846, -1845, -1843, -1842, -1840, -1840, -1839, -1837, -1830, -1830, -1826, -1826, -1821, -1821, -1821, -1819, -1817, -1814, -1808, -1807, -1805, -1804, -1800, -1800, -1792, -1792, -1792, -1790, -1788, -1786, -1779, -1777, -1777, -1776, -1775, -1773, -1772, -1768, -1767, -1765, -1764, -1760, -1756, -1756, -1752, -1743, -1743, -1742, -1741, -1733, -1732, -1731, -1730, -1729, -1729, -1724, -1723, -1721, -1720, -1719, -1718, -1717, -1711, -1711, -1710, -1707, -1705, -1704, -1695, -1695, -1693, -1689, -1688, -1687, -1687, -1684, -1684, -1683, -1680, -1679, -1678, -1678, -1677, -1676, -1676, -1671, -1671, -1671, -1662, -1659, -1659, -1656, -1655, -1655, -1652, -1644, -1631, -1630, -1628, -1626, -1626, -1623, -1623, -1621, -1620, -1618, -1615, -1614, -1613, -1605, -1604, -1601, -1599, -1597, -1597, -1596, -1584, -1582, -1579, -1576, -1576, -1574, -1574, -1573, -1572, -1571, -1570, -1569, -1567, -1565, -1565, -1557, -1555, -1550, -1550, -1550, -1543, -1540, -1538, -1538, -1534, -1534, -1534, -1531, -1525, -1520, -1519, -1518, -1517, -1517, -1516, -1509, -1508, -1506, -1504, -1499, -1498, -1497, -1497, -1494, -1494, -1490, -1488, -1487, -1483, -1481, -1480, -1477, -1470, -1460, -1459, -1455, -1451, -1448, -1440, -1437, -1435, -1432, -1431, -1431, -1431, -1430, -1430, -1423, -1420, -1419, -1419, -1418, -1414, -1414, -1412, -1409, -1407, -1400, -1396, -1394, -1390, -1390, -1389, -1387, -1386, -1385, -1384, -1383, -1383, -1383, -1383, -1381, -1381, -1379, -1379, -1377, -1375, -1374, -1373, -1370, -1370, -1367, -1357, -1357, -1356, -1353, -1352, -1348, -1347, -1347, -1346, -1344, -1340, -1337, -1336, -1335, -1331, -1321, -1320, -1319, -1317, -1313, -1311, -1305, -1304, -1302, -1301, -1300, -1299, -1297, -1296, -1294, -1290, -1288, -1288, -1287, -1286, -1283, -1281, -1281, -1280, -1278, -1277, -1275, -1272, -1269, -1265, -1263, -1263, -1261, -1258, -1258, -1255, -1252, -1250, -1250, -1248, -1243, -1242, -1241, -1238, -1229, -1229, -1229, -1229, -1227, -1227, -1224, -1223, -1216, -1212, -1211, -1205, -1203, -1202, -1200, -1199, -1197, -1195, -1194, -1194, -1194, -1190, -1190, -1190, -1189, -1189, -1188, -1186, -1186, -1186, -1181, -1181, -1175, -1171, -1171, -1170, -1168, -1166, -1164, -1163, -1159, -1157, -1153, -1152, -1149, -1148, -1147, -1146, -1145, -1143, -1142, -1142, -1138, -1137, -1136, -1135, -1134, -1133, -1131, -1127, -1126, -1124, -1122, -1121, -1121, -1120, -1119, -1117, -1117, -1115, -1108, -1108, -1107, -1106, -1106, -1105, -1103, -1100, -1097, -1091, -1090, -1089, -1089, -1089, -1088, -1088, -1086, -1085, -1082, -1081, -1081, -1078, -1077, -1073, -1068, -1068, -1068, -1067, -1064, -1061, -1061, -1059, -1057, -1056, -1056, -1053, -1053, -1051, -1047, -1043, -1043, -1035, -1035, -1032, -1030, -1028, -1026, -1025, -1021, -1019, -1018, -1012, -1008, -1006, -1005, -1005, -1003, -999, -998, -997, -996, -995, -992, -991, -989, -987, -983, -980, -978, -976, -975, -973, -969, -969, -969, -966, -966, -965, -962, -962, -961, -959, -959, -956, -954, -954, -951, -949, -948, -947, -941, -937, -933, -930, -930, -927, -924, -923, -923, -922, -919, -914, -913, -913, -909, -909, -904, -904, -903, -900, -896, -895, -892, -888, -888, -887, -884, -882, -882, -881, -880, -879, -875, -871, -865, -865, -864, -862, -861, -859, -856, -856, -856, -855, -854, -853, -851, -849, -842, -841, -841, -840, -837, -836, -835, -832, -832, -831, -831, -830, -829, -828, -825, -823, -822, -821, -819, -817, -816, -816, -815, -815, -814, -806, -804, -804, -803, -802, -799, -798, -796, -795, -794, -794, -793, -790, -788, -787, -781, -781, -777, -777, -776, -776, -770, -768, -768, -762, -762, -760, -759, -758, -756, -755, -746, -746, -741, -739, -735, -734, -724, -723, -723, -721, -715, -705, -702, -701, -700, -696, -695, -694, -692, -692, -690, -690, -688, -688, -686, -682, -677, -673, -673, -672, -670, -670, -670, -669, -652, -652, -649, -647, -646, -646, -640, -637, -637, -633, -632, -632, -631, -629, -627, -622, -622, -620, -620, -618, -614, -611, -610, -608, -608, -607, -606, -606, -605, -602, -588, -587, -585, -585, -583, -583, -582, -577, -577, -577, -574, -574, -572, -570, -568, -568, -566, -562, -562, -559, -554, -551, -547, -543, -542, -540, -533, -530, -529, -527, -524, -524, -524, -523, -523, -522, -521, -521, -519, -514, -508, -506, -505, -504, -504, -501, -500, -499, -495, -490, -487, -486, -485, -483, -483, -482, -482, -482, -482, -478, -477, -476, -475, -472, -472, -469, -468, -467, -467, -466, -463, -458, -458, -454, -452, -445, -443, -443, -439, -436, -436, -436, -434, -430, -429, -428, -427, -427, -426, -426, -422, -421, -420, -418, -416, -415, -414, -411, -409, -409, -409, -406, -406, -403, -402, -401, -397, -396, -396, -394, -387, -387, -386, -385, -378, -378, -377, -376, -369, -359, -357, -352, -350, -347, -344, -344, -342, -341, -336, -331, -329, -329, -329, -327, -326, -325, -324, -323, -322, -319, -314, -307, -300, -298, -294, -293, -288, -288, -287, -284, -282, -278, -278, -273, -273, -272, -271, -268, -267, -262, -261, -260, -259, -257, -257, -254, -253, -252, -252, -248, -248, -247, -243, -243, -241, -239, -239, -237, -232, -232, -231, -229, -226, -220, -216, -213, -213, -210, -210, -208, -207, -201, -199, -198, -198, -197, -197, -197, -196, -196, -195, -192, -191, -190, -186, -179, -174, -174, -173, -173, -172, -172, -172, -171, -164, -160, -158, -151, -146, -136, -131, -127, -127, -126, -124, -123, -123, -123, -122, -121, -119, -116, -115, -114, -111, -111, -106, -104, -103, -103, -101, -97, -89, -88, -87, -82, -79, -71, -71, -65, -63, -61, -56, -55, -54, -51, -46, -46, -46, -45, -44, -35, -34, -34, -33, -27, -20, -19, -18, -16, -10, -8, -8, -7, -6, -6, -4, -4, -1,
                1, 1, 3, 6, 9, 10, 10, 10, 14, 16, 24, 30, 31, 33, 34, 36, 37, 37, 38, 43, 46, 46, 51, 59, 61, 62, 63, 65, 67, 67, 68, 69, 71, 71, 71, 72, 74, 77, 79, 87, 89, 89, 99, 103, 104, 105, 107, 108, 109, 109, 109, 110, 112, 112, 114, 116, 118, 120, 126, 126, 128, 129, 134, 136, 136, 137, 139, 145, 146, 146, 150, 151, 151, 151, 154, 154, 155, 157, 159, 160, 162, 163, 163, 163, 163, 164, 165, 166, 168, 170, 171, 172, 174, 177, 180, 180, 184, 184, 184, 186, 187, 192, 192, 194, 195, 195, 196, 196, 196, 200, 200, 201, 204, 206, 206, 206, 207, 211, 216, 220, 222, 223, 223, 227, 229, 231, 236, 236, 237, 238, 244, 245, 246, 247, 248, 248, 249, 254, 257, 258, 258, 260, 260, 262, 262, 272, 275, 278, 281, 285, 287, 290, 292, 294, 295, 295, 296, 304, 307, 315, 316, 317, 317, 321, 325, 327, 328, 329, 331, 332, 332, 335, 335, 336, 339, 340, 341, 345, 350, 350, 352, 352, 352, 355, 356, 358, 359, 362, 364, 368, 370, 370, 380, 380, 382, 382, 384, 386, 387, 388, 395, 397, 399, 399, 402, 406, 406, 412, 413, 416, 417, 418, 420, 420, 421, 428, 429, 431, 435, 437, 438, 441, 443, 449, 452, 453, 454, 455, 455, 457, 458, 462, 463, 464, 464, 467, 469, 469, 473, 475, 475, 481, 482, 482, 483, 484, 486, 490, 492, 492, 493, 493, 494, 496, 498, 503, 505, 506, 507, 513, 515, 518, 519, 519, 525, 525, 527, 533, 533, 538, 541, 541, 542, 544, 548, 549, 549, 552, 552, 554, 556, 558, 563, 563, 565, 566, 566, 566, 567, 570, 571, 575, 583, 585, 585, 587, 587, 587, 588, 589, 594, 596, 596, 597, 599, 599, 603, 604, 605, 610, 616, 618, 621, 621, 622, 624, 626, 627, 627, 628, 630, 630, 638, 644, 644, 648, 651, 655, 658, 660, 663, 665, 666, 667, 673, 677, 677, 678, 679, 679, 681, 689, 691, 691, 692, 696, 697, 698, 699, 703, 705, 706, 707, 707, 710, 714, 715, 720, 720, 721, 729, 729, 730, 733, 733, 735, 735, 738, 741, 742, 743, 745, 745, 747, 749, 753, 755, 755, 755, 763, 763, 769, 771, 775, 776, 777, 781, 782, 783, 783, 784, 787, 794, 794, 804, 805, 808, 809, 811, 811, 811, 814, 815, 819, 821, 821, 822, 825, 829, 830, 830, 831, 831, 831, 833, 835, 837, 837, 840, 841, 841, 843, 852, 852, 853, 855, 855, 856, 856, 863, 867, 868, 868, 872, 872, 874, 874, 876, 877, 878, 880, 880, 883, 888, 888, 889, 891, 892, 892, 892, 895, 896, 896, 901, 903, 904, 906, 908, 909, 912, 913, 914, 920, 925, 926, 928, 933, 937, 937, 939, 944, 945, 949, 950, 957, 960, 961, 962, 962, 963, 966, 969, 973, 976, 978, 978, 981, 982, 982, 984, 986, 991, 993, 995, 996, 998, 998, 1004, 1007, 1010, 1013, 1018, 1019, 1020, 1021, 1021, 1024, 1030, 1032, 1034, 1035, 1035, 1035, 1039, 1039, 1039, 1040, 1041, 1041, 1042, 1042, 1047, 1052, 1052, 1053, 1055, 1055, 1063, 1066, 1069, 1070, 1071, 1072, 1073, 1074, 1074, 1077, 1079, 1080, 1082, 1084, 1084, 1086, 1092, 1095, 1100, 1100, 1102, 1102, 1103, 1105, 1106, 1106, 1108, 1108, 1109, 1112, 1113, 1113, 1117, 1118, 1120, 1120, 1125, 1126, 1128, 1131, 1134, 1135, 1136, 1139, 1143, 1145, 1155, 1156, 1156, 1162, 1163, 1163, 1167, 1168, 1172, 1175, 1177, 1179, 1183, 1185, 1186, 1187, 1187, 1188, 1188, 1193, 1196, 1199, 1199, 1201, 1203, 1206, 1207, 1207, 1211, 1211, 1213, 1215, 1215, 1215, 1215, 1216, 1217, 1217, 1218, 1219, 1219, 1219, 1222, 1227, 1232, 1234, 1235, 1235, 1236, 1237, 1237, 1239, 1241, 1245, 1247, 1252, 1253, 1256, 1256, 1256, 1265, 1270, 1271, 1272, 1273, 1273, 1274, 1276, 1278, 1289, 1294, 1295, 1297, 1298, 1298, 1304, 1305, 1306, 1306, 1307, 1308, 1310, 1311, 1312, 1313, 1318, 1320, 1322, 1323, 1323, 1323, 1329, 1330, 1330, 1333, 1341, 1342, 1343, 1344, 1344, 1347, 1355, 1356, 1358, 1359, 1359, 1360, 1360, 1361, 1362, 1362, 1363, 1364, 1365, 1366, 1367, 1369, 1371, 1373, 1374, 1376, 1378, 1379, 1382, 1382, 1382, 1384, 1386, 1389, 1390, 1391, 1391, 1391, 1395, 1396, 1397, 1399, 1399, 1403, 1404, 1405, 1405, 1405, 1406, 1407, 1408, 1408, 1409, 1409, 1409, 1410, 1411, 1413, 1413, 1415, 1416, 1416, 1417, 1419, 1420, 1425, 1430, 1433, 1438, 1439, 1442, 1442, 1445, 1453, 1453, 1454, 1455, 1457, 1458, 1460, 1460, 1461, 1462, 1467, 1468, 1469, 1472, 1473, 1474, 1476, 1478, 1479, 1480, 1482, 1483, 1490, 1491, 1493, 1493, 1496, 1500, 1501, 1503, 1504, 1505, 1508, 1508, 1508, 1512, 1514, 1519, 1522, 1526, 1526, 1527, 1528, 1529, 1531, 1531, 1537, 1537, 1545, 1547, 1549, 1550, 1557, 1563, 1565, 1571, 1578, 1578, 1581, 1581, 1584, 1584, 1585, 1588, 1589, 1596, 1597, 1599, 1602, 1603, 1607, 1607, 1608, 1610, 1612, 1618, 1627, 1631, 1632, 1632, 1633, 1633, 1634, 1638, 1642, 1647, 1647, 1648, 1649, 1649, 1656, 1656, 1656, 1659, 1659, 1662, 1667, 1669, 1670, 1671, 1671, 1675, 1675, 1676, 1682, 1683, 1683, 1683, 1687, 1688, 1691, 1691, 1691, 1692, 1694, 1697, 1697, 1698, 1700, 1703, 1705, 1706, 1708, 1709, 1709, 1712, 1712, 1716, 1720, 1721, 1723, 1723, 1725, 1728, 1731, 1732, 1733, 1733, 1735, 1737, 1738, 1742, 1744, 1744, 1747, 1747, 1749, 1749, 1749, 1752, 1752, 1754, 1762, 1766, 1769, 1770, 1770, 1771, 1771, 1773, 1781, 1782, 1782, 1783, 1784, 1784, 1786, 1786, 1788, 1788, 1788, 1790, 1799, 1800, 1800, 1805, 1808, 1808, 1808, 1810, 1810, 1812, 1813, 1816, 1817, 1817, 1820, 1820, 1822, 1822, 1826, 1827, 1830, 1831, 1832, 1832, 1833, 1837, 1838, 1844, 1844, 1849, 1851, 1851, 1852, 1853, 1853, 1854, 1854, 1855, 1858, 1859, 1862, 1862, 1863, 1864, 1864, 1865, 1868, 1870, 1872, 1873, 1875, 1877, 1877, 1883, 1883, 1888, 1888, 1889, 1889, 1890, 1890, 1892, 1892, 1893, 1894, 1898, 1900, 1901, 1902, 1903, 1904, 1905, 1908, 1909, 1912, 1914, 1914, 1915, 1915, 1922, 1927, 1927, 1931, 1932, 1933, 1934, 1935, 1937, 1938, 1940, 1944, 1947, 1950, 1953, 1958, 1958, 1961, 1961, 1962, 1965, 1966, 1966, 1968, 1968, 1969, 1969, 1971, 1972, 1975, 1978, 1979, 1982, 1982, 1983, 1983, 1983, 1984, 1991, 1992, 1996, 1999, 1999
        });
        System.out.println(i);
    }

    public int maximumCount(int[] nums) {
        // 二分查找 0 和 1
        int zeroIndex = binarySearch(nums, 0);
        int oneIndex = binarySearch(nums, 1);

        int negCount = zeroIndex;
        int posCount = nums.length - oneIndex;
        return Math.max(negCount, posCount);
    }

    // 查找target第一次出现的下标，如果不存在，则返回应该插入的下标
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 这里不能mid直接return
            if (nums[mid] < target) {
                left = mid + 1;
            } else {    // 相等，向左收缩
                right = mid;
            }
        }
        // 最终 left = right，且 nums[left - 1] < target，故 left是第一个 >= target的数
        return left;
    }


}
