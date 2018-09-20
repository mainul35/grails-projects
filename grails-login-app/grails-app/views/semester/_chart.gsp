<canvas id="myChart" width="100" height="100"></canvas>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var myPieChart = new Chart(ctx, {
        type: 'line',
        data: {
            label: ["semester 1", "semester 2"],
            datasets: [{
                backdropColor: "rgba(100, 200, 120, 0.4)",
                pointBorderWidth: 1,
                data: [5, 7]
            }]
        },

    });
</script>
