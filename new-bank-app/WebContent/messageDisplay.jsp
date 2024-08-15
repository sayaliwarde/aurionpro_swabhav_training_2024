<% if (request.getAttribute("message") != null) { %>
    <div class="alert alert-info mt-3">
        <%= request.getAttribute("message") %>
    </div>
<% } %>
