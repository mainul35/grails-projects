<div class="form-group">
    <label for="role">Roles</label>

    <g:select
            id="role"
            data-placeholder="Select roles..."
            multiple="true"
            class="standardSelect"
            name="roles"
            from="${allRoles}"
            optionKey="id"
            value="" optionValue="${{ it.authority }}"
            noSelection="${['null': '']}">
    </g:select>
</div>