/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

const itemsPerPage = 5;
let currentPage = 1;
let timeoutId;

$(document).ready(function () {
    let data = {
        page: currentPage
    };
    $.ajax({
        type: 'POST',
        url: '/dms/list-debtor',
        data: data,
        success: function (response) {
            var listDebtor = JSON.parse(response);
            renderListDebtor(listDebtor);
            renderPagination(currentPage, Math.ceil(listDebtor[listDebtor.length - 1] / itemsPerPage), onPageChange, '/dms/list-debtor', data);
        }
    });
});

function delaySearch() {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(search, 500);
}

function search() {
    let data = {
        searchName: $("#searchName").val(),
        searchAddress: $("#searchAddress").val(),
        searchEmail: $("#searchEmail").val(),
        searchPhone: $("#searchPhone").val(),
        searchGender: $("#searchGender").find(":selected").val(),
        debtFrom: $("#debtFrom").val(),
        debtTo: $("#debtTo").val(),
        page: currentPage
    };
    $.ajax({
        type: 'POST',
        url: '/dms/search-debtor',
        data: data,
        success: function (response) {
            var listDebtor = JSON.parse(response);
            renderListDebtor(listDebtor);
            renderPagination(currentPage, Math.ceil(listDebtor[listDebtor.length - 1] / itemsPerPage), onPageChange, '/dms/search-debtor', data);
            if (listDebtor.length === 1) {
                document.getElementById("listDebtor").innerHTML = 'Không có kết quả phù hợp';
            }

        }
    });
}

let renderListDebtor = (listDebtor) => {
    var listDebtorHtml = ``;
    
    listDebtor.forEach((debtor, index) => {
        if (index !== listDebtor.length - 1) {
            var gender = "";
            switch (debtor.genderId) {
                case "1":
                    gender = "Nam";
                    break;
                case "2":
                    gender = "Nữ";
                    break;
                default:
                    gender = "Giới tính khác";
                    break;
            }
            var style;
            ;
            if (debtor.totalDebt >= 0) {
                style = "color:blue";
            } else {
                style = "color:red";

            }
  
            listDebtorHtml += `
            <tr>
                <td style=${style}>${debtor.fullName}</td>
                <td style=${style}>${debtor.address}</td>
                <td style=${style}>${debtor.mobilePhone}</td>
                <td style=${style}>${debtor.email}</td>
                <td style=${style}>${gender}</td>
                <td style=${style}>${debtor.totalDebt.toLocaleString() + "đ"} </td>
                    <td>
                        <div class="d-flex">
                            <a 
                                href="viewdetailsdebtor?did=${debtor.id}"
                                id="${debtor.id}" 
                                class="btn btn-primary shadow btn-xs sharp mr-1">
                                <i class="fa fa-info"></i>
                            </a>
                            <a 
                                id="${debtor.id}"
                                href="javascript:void(0);" 
                                data-toggle="modal" 
                                data-target="#CreateDebtMenus" 
                                class="btn btn-primary shadow btn-xs sharp mr-1">
                                <i class="fa fa-plus"></i>
                            </a>
                            <a 
                                id="${debtor.id}"
                                href="javascript:void(0);" 
                                data-toggle="modal" 
                                data-target="#UpdateDebtorMenus" 
                                class="btn btn-warning shadow btn-xs sharp mr-1"
                                onclick="viewDebtor(${debtor.id})">
                                <i class="fa fa-pencil"></i>
                            </a>
                        </div>
                    </td>
            </tr>
            `;
        }
    });
    document.getElementById("listDebtor").innerHTML = listDebtorHtml;
};

function renderPagination(currentPage, totalPages, onPageChange, url, data) {
    const container = document.querySelector('#pagination-container');
    container.innerHTML = '';

    const maxPagesDisplayed = 5;
    const startPage = Math.max(currentPage - Math.floor(maxPagesDisplayed / 2), 1);
    const endPage = Math.min(startPage + maxPagesDisplayed - 1, totalPages);

    const buttonWrap = document.createElement('li');
    const prevButton = document.createElement('button');
    buttonWrap.classList.add('page-item', 'active');
    prevButton.classList.add("page-link");
    prevButton.textContent = "Previous";
    if (currentPage > 1) {
        prevButton.addEventListener('click', event => {
            event.preventDefault();
            onPageChange(currentPage - 1, url, data);
        });
        buttonWrap.classList.add('active');
    } else {
        buttonWrap.classList.remove('active');
    }

    buttonWrap.appendChild(prevButton);
    container.appendChild(buttonWrap);

    for (let i = startPage; i <= endPage; i++) {
        const link_wrap = document.createElement('li');
        const link = document.createElement('a');
        link.textContent = i;
        link.href = '#';
        if (i === currentPage) {
            link_wrap.classList.add('page-item', 'active');
            link.classList.add('page-link', 'current-page');
        } else {
            link_wrap.classList.add('page-item');
            link.classList.add('page-link');
        }
        link_wrap.appendChild(link);
        link_wrap.addEventListener('click', event => {
            event.preventDefault();
            onPageChange(i, url, data);
        });
        container.appendChild(link_wrap);
    }

    const buttonNextWrap = document.createElement('li');
    const nextButton = document.createElement('button');
    buttonNextWrap.classList.add('page-item', 'active');
    nextButton.classList.add("page-link");
    nextButton.textContent = "Next";
    if (currentPage < totalPages) {
        nextButton.addEventListener('click', event => {
            event.preventDefault();
            onPageChange(currentPage + 1, url, data);
        });
        buttonNextWrap.classList.add('active');
    } else {
        buttonNextWrap.classList.remove('active');
    }

    buttonNextWrap.appendChild(nextButton);
    container.appendChild(buttonNextWrap);

}

function onPageChange(newPage, url, data) {
    data['page'] = newPage;
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        success: function (response) {
            var listDebtor = JSON.parse(response);
            renderListDebtor(listDebtor);
            renderPagination(newPage, Math.ceil(listDebtor[listDebtor.length - 1] / itemsPerPage), onPageChange, url, data);
        }
    });
}

function viewDebtor(id) {
    $.ajax({

        type: 'POST',
        url: '/dms/view-debtor',
        data: {
            debtorId: id
        },

        success: function (response) {
            var debtor = JSON.parse(response);
            console.log(debtor)
            $("#debtorIdUpdate").val(id);
            $("#nameUpdate").val(debtor.fullName);
            $("#addressUpdate").val(debtor.address);
            $("#phoneUpdate").val(debtor.mobilePhone);
            $("#emailUpdate").val(debtor.email);
            $("#debtUpdate").val(debtor.totalDebt);
        }
    });
}
