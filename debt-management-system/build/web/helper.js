function numberToWords(num) {
    var ones = ['', 'một', 'hai', 'ba', 'bốn', 'năm', 'sáu', 'bảy', 'tám', 'chín', 'mười', 'mười một', 'mười hai', 'mười ba', 'mười bốn', 'mười lăm', 'mười sáu', 'mười bảy', 'mười tám', 'mười chín'];
    var tens = ['', 'mười', 'hai mươi', 'ba mươi', 'bốn mươi', 'năm mươi', 'sáu mươi', 'bảy mươi', 'tám mươi', 'chín mươi'];
    var scales = ['', 'nghìn', 'triệu', 'tỷ', 'nghìn tỷ', 'triệu tỷ', 'nghìn triệu tỷ', 'tỷ tỷ'];

    // Convert the number to a big integer
    var bigNum = bigInt(num);

    // Handle the special case of zero
    if (bigNum.eq(0)) {
        return 'không';
    }

    // Split the number into groups of three digits
    var groups = [];
    while (bigNum.gt(0)) {
        groups.push(bigNum.mod(1000));
        bigNum = bigNum.divide(1000);
    }

    // Convert each group to words
    var groupWords = [];
    for (var i = 0; i < groups.length; i++) {
        var group = groups[i];
        var groupWord = '';

        if (group.gt(99)) {
            groupWord += ones[group.divide(100).toJSNumber()] + ' trăm ';
            group = group.mod(100);
        }

        if (group.gt(19)) {
            groupWord += tens[group.divide(10).toJSNumber()] + ' ';
            group = group.mod(10);
            if (group.eq(1)) {
                groupWord += 'mốt';
                group = bigInt(0);
            }
        }

        if (group.gt(0)) {
            if (group.eq(1) && i == 1) {
                groupWord += 'một ';
            } else {
                groupWord += ones[group.toJSNumber()] + ' ';
            }
        }

        if (groupWord !== '') {
            groupWord += scales[i] + ' ';
        }

        groupWords.push(groupWord);
    }

    // Combine the group words and return the result
    return groupWords.reverse().join('').trim();
}
