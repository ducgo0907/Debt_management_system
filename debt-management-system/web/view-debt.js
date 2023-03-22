
function viewDebt(id) {
    $.ajax({
        type: 'POST',
        url: '/dms/view-debt',
        data: {
            debtId: id
        },
        success: function (response) {
            var debt = JSON.parse(response);
            console.log(debt)
            const price = Math.round(debt.money * 10) / 10;
            const resultd = (price).toLocaleString('en-US', {
                maximumSignificantDigits: 3
            });
            let isdebt;
            if (debt.isDebt == true || debt.isDebt == "true") {
                isdebt = "Cho vay";
            } else {
                isdebt = "Nợ";
            }
            console.log(resultd + " ₫")
            $("#debtId").val(id);
            $("#noteDetail").val(debt.note);
            $("#isDebtDetails").val(isdebt);
            $("#dmoney").val(resultd);
            $("#createdAt").val(debt.createdAt);
            $("#startDate").val(debt.startDate);



        }
    });
}
function delaySearch() {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(search, 300);
}
function search() {
            console.log("sss");
    let data = {
//        searchStt: $("#searchStt").val(),
        searchNote: $("#searchNote").val(),
        searchType: $("#searchType").find(":selected").val(),
        debtFrom: $("#debtFrom").val(),
        debtTo: $("#debtTo").val(),
        addFrom: $("#addFrom").val(),
        addTo: $("#addTo").val(),
        createFrom: $("#createFrom").val(),
        createTo: $("#createTo").val(),
    };
    $.ajax({
        type: 'POST',
        url: '/dms/search-debt',
        data: data,
        success: function (response) {
            var listDebtor = JSON.parse(response);
            renderListDebtor(listDebtor);
            renderPagination(currentPage, Math.ceil(listDebtor[listDebtor.length - 1] / itemsPerPage), onPageChange, '/dms/search-debtor', data);
//            if (listDebtor.length === 1) {
//                document.getElementById("listDebtor").innerHTML = 'Không có kết quả phù hợp';
//            }

        }
    });
}
