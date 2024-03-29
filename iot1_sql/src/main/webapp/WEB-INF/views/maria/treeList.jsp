<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


    <base href="http://demos.telerik.com/kendo-ui/menu/menu-bind-attributes">
    <style>html { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.3.913/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.3.913/styles/kendo.material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.3.913/styles/kendo.material.mobile.min.css" />

    <script src="https://kendo.cdn.telerik.com/2017.3.913/js/jquery.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2017.3.913/js/kendo.all.min.js"></script>
    

</head>
<body>

<div id="example">


    <div class="demo-section k-content wide">
        <div id="products-wrapper">
            <ul id="menu"></ul>
            <div id="products"></div>
        </div>
        <div id="product-wrapper">
            <h3 class="bottom-border">Product Details:</h3>
            <div id="product"></div>
        </div>
    </div>
<!--
    <script type="text/x-kendo-tmpl" id="template">
        <div class="product">
            <img src="http://demos.telerik.com/kendo-ui/content/web/foods/#:ProductID#.jpg" alt="#:ProductName# image" />
            <div class="product-description">
                <h3>#:ProductName#</h3>
            </div>
        </div>
    </script>

    <script type="text/x-kendo-tmpl" id="productCard">
        <div class="productCard">
            <h3>#:ProductName#</h3>
            <p><img src="http://demos.telerik.com/kendo-ui/content/web/foods/#:ProductID#.jpg" alt="#:ProductName# image" /></p>
            <div class="product-description">
                <table>
                    <tr>
                        <th>Price</th>
                        <td>#: kendo.toString(parseFloat(UnitPrice), "c") #</td>
                    </tr>
                    <tr>
                        <th>Units</th>
                        <td>#: UnitsInStock #</td>
                    </tr>
                    <tr>
                        <th>Discontinued</th>
                        <td>#: Discontinued ? 'Yes' : 'No' #</td>
                    </tr>
                </table>
            </div>
        </div>
    </script>
  -->
    <script>
        $(document).ready(function () {
            menuRendered = false;
            dsCategories = null;
            dsProducts = null;
            var template = kendo.template($("#template").html());
            var productCard = kendo.template($("#productCard").html());

            dsCategories = new kendo.data.DataSource({
                type: "odata",
                transport: {
                    read: {
                        url: "https://demos.telerik.com/kendo-ui/service/Northwind.svc/Categories",
                        dataType: "jsonp"
                    }
                }
            });


            dsProducts = new kendo.data.DataSource({
                type: "odata",
                transport: {
                    read: {
                        url: "https://demos.telerik.com/kendo-ui/service/Northwind.svc/Products",
                        dataType: "jsonp"
                    }
                },
                requestStart: function () {
                    kendo.ui.progress($("#products"), true);
                },
                requestEnd: function () {
                    kendo.ui.progress($("#products"), false);
                }
            });

            dsCategories.fetch(function () {
                prepareMenuDataSource();
            });

            dsProducts.fetch(function () {
                prepareMenuDataSource();
            });

            function prepareMenuDataSource() {
                if (menuRendered) {
                    return;
                } else if (dsCategories.view().length > 0) {
                    menuRendered = true;
                }

                var menuDataSource = [];

                for (var i = 0; i < dsCategories.view().length ; i++) {
                    var item = dsCategories.view()[i];
                    menuDataSource.push({
                        text: item.CategoryName,
                        attr: {
                            categoryid: item.CategoryID,
                            title: item.Description
                        },
                        items: getProducts(item.CategoryID)
                    })

                }

                renderProduct();
                renderMenu(menuDataSource)
            }

            function getProducts(id) {

                dsProducts.filter({ field: "CategoryID", operator: "eq", value: id });

                var result = [];

                for (var i = 0; i < dsProducts.view().length ; i++) {
                    var item = dsProducts.view()[i];
                    result.push({
                        text: item.ProductName,
                        attr: {
                            categoryid: item.CategoryID,
                            productid: item.ProductID,
                            datasourceuid: item.uid,
                            unitprice: item.UnitPrice,
                            unitsinstock: item.UnitsInStock
                        }
                    })

                }
                return result;
            }

            function renderProduct() {
                $("#product").html(productCard(dsProducts.at(0)));
            }

            function renderMenu(dataSource) {
                $("#menu").kendoMenu({
                    dataSource: dataSource,
                    select: onMenuSelect
                });

                dsProducts.bind("change", renderCategory);
                dsProducts.filter({ field: "CategoryID", operator: "eq", value: 1 });
            }

            function onMenuSelect(ev) {
                showCategory($(ev.item).attr("categoryid"));

                var datasourceuid = $(ev.item).attr("datasourceuid");
                if (datasourceuid) {
                    $("#product").html(productCard(dsProducts.getByUid(datasourceuid)));
                }
            }

            function showCategory(id) {
                dsProducts.filter({ field: "CategoryID", operator: "eq", value: id });
            }

            function renderCategory(ev) {
                $("#products").html(kendo.render(template, this.view()));
            }
        });
    </script>


    <style>
        #products-wrapper {
            width: 80%;
            display: inline-block;
            vertical-align: top;
            border-right: 1px solid rgba(20, 53, 80, 0.137255);
            padding-right: 40px;
        }

        #product-wrapper {
            height: 100%;
            margin: 15px 0 0 50px;
            display: inline-block;
        }

        #products {
            margin-top: 10px;
        }

        .product {
            margin: 20px 5px 0 0;
            display: inline-block;
            vertical-align: top;
        }

            .product img, .productCard img {
                width: 110px;
                height: 110px;
            }

            .product h3 {
                max-width:110px;
            }

            .product h3, #product-wrapper h3 {
                display: inline-block;
                margin: 0;
                padding: 3px 5px 0 0;
                overflow: hidden;
                line-height: 1.1em;
                font-size: .9em;
                font-weight: normal;
                text-transform: uppercase;
                color: #999;
            }

        #product-wrapper h3 {
            color: #999;
        }

        .productCard {
            margin-top:30px;
        }

            .productCard table {
                margin-top:20px;
                text-align: left;
                font-size: .9em;
                color: #999;
            }
    </style>
</div>


</body>
</html>

</body>
</html>